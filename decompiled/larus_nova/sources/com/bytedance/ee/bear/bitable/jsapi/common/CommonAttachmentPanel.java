package com.bytedance.ee.bear.bitable.jsapi.common;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Base64;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.bitable.jsapi.BitableJSApiErrorCode;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.LocalOpenEntity;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority$UploadPriority;
import com.bytedance.ee.bear.middleground.drive.export.UploadRequestInfo;
import com.bytedance.ee.bear.quoto.t;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.LarkUriUtil;
import com.larksuite.framework.utils.l0;
import com.larus.nova.R;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class CommonAttachmentPanel {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f214342c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, AttachmentInfo> f214343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f214344b;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/common/CommonAttachmentPanel$AttachmentCheckedInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "attachmentID", "", "valid", "", "<init>", "(Ljava/lang/String;Z)V", "getAttachmentID", "()Ljava/lang/String;", "getValid", "()Z", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AttachmentCheckedInfo implements NonProguard {
        private final String attachmentID;
        private final boolean valid;

        public final String getAttachmentID() {
            return this.attachmentID;
        }

        public final boolean getValid() {
            return this.valid;
        }

        public AttachmentCheckedInfo(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "attachmentID");
            this.attachmentID = r100;
            this.valid = r101;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R \u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u001c¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/common/CommonAttachmentPanel$AttachmentInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "attachmentID", "", DBDefinition.MIME_TYPE, "size", "", "name", "base64Image", "width", "", "height", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAttachmentID", "()Ljava/lang/String;", "getMimeType", "getSize", "()J", "getName", "getBase64Image", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "path", "getPath", "setPath", "(Ljava/lang/String;)V", "uri", "getUri", "setUri", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AttachmentInfo implements NonProguard {
        private final String attachmentID;
        private final String base64Image;
        private final Integer height;
        private final String mimeType;
        private final String name;

        @JSONField(deserialize = false, serialize = false)
        private String path;
        private final long size;

        @JSONField(deserialize = false, serialize = false)
        private String uri;
        private final Integer width;

        public final String getAttachmentID() {
            return this.attachmentID;
        }

        public final String getBase64Image() {
            return this.base64Image;
        }

        public final Integer getHeight() {
            return this.height;
        }

        public final String getMimeType() {
            return this.mimeType;
        }

        public final String getName() {
            return this.name;
        }

        public final String getPath() {
            return this.path;
        }

        public final long getSize() {
            return this.size;
        }

        public final String getUri() {
            return this.uri;
        }

        public final Integer getWidth() {
            return this.width;
        }

        public final void setPath(String r100) {
            this.path = r100;
        }

        public final void setUri(String r100) {
            this.uri = r100;
        }

        public AttachmentInfo(String r100, String r101, long r102, String r103, String r104, Integer r105, Integer r106) {
            Intrinsics.checkNotNullParameter(r100, "attachmentID");
            Intrinsics.checkNotNullParameter(r101, DBDefinition.MIME_TYPE);
            Intrinsics.checkNotNullParameter(r103, "name");
            this.attachmentID = r100;
            this.mimeType = r101;
            this.size = r102;
            this.name = r103;
            this.base64Image = r104;
            this.width = r105;
            this.height = r106;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/common/CommonAttachmentPanel$AuthCodeResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "uploadCode", "", "<init>", "(Ljava/lang/String;)V", "getUploadCode", "()Ljava/lang/String;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AuthCodeResult implements NonProguard {
        private final String uploadCode;

        /* JADX WARN: Multi-variable type inference failed */
        public AuthCodeResult() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final String getUploadCode() {
            return this.uploadCode;
        }

        public AuthCodeResult(String r100) {
            this.uploadCode = r100;
        }

        public /* synthetic */ AuthCodeResult(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/common/CommonAttachmentPanel$CheckAttachmentRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "attachmentIDs", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getAttachmentIDs", "()Ljava/util/ArrayList;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CheckAttachmentRequest implements NonProguard {
        private final ArrayList<String> attachmentIDs;

        public final ArrayList<String> getAttachmentIDs() {
            return this.attachmentIDs;
        }

        public CheckAttachmentRequest(ArrayList<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "attachmentIDs");
            this.attachmentIDs = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\r\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/common/CommonAttachmentPanel$ChooseAttachmentRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "mode", "", "count", "", "mediaType", "", "acceptFileTypes", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;[Ljava/lang/String;[Ljava/lang/String;)V", "getMode", "()Ljava/lang/String;", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMediaType", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getAcceptFileTypes", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChooseAttachmentRequest implements NonProguard {
        private final String[] acceptFileTypes;
        private final Integer count;
        private final String[] mediaType;
        private final String mode;

        public ChooseAttachmentRequest() {
            this(null, null, null, null, 15, null);
        }

        public final String[] getAcceptFileTypes() {
            return this.acceptFileTypes;
        }

        public final Integer getCount() {
            return this.count;
        }

        public final String[] getMediaType() {
            return this.mediaType;
        }

        public final String getMode() {
            return this.mode;
        }

        public ChooseAttachmentRequest(String r100, Integer r101, String[] r102, String[] r103) {
            Intrinsics.checkNotNullParameter(r100, "mode");
            this.mode = r100;
            this.count = r101;
            this.mediaType = r102;
            this.acceptFileTypes = r103;
        }

        public /* synthetic */ ChooseAttachmentRequest(String r100, Integer r101, String[] r102, String[] r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = "defalut";
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = 9;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = new String[]{"image", "video"};
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = new String[0];
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/common/CommonAttachmentPanel$DeleteAttachmentRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "attachmentIDs", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getAttachmentIDs", "()Ljava/util/ArrayList;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DeleteAttachmentRequest implements NonProguard {
        private final ArrayList<String> attachmentIDs;

        public final ArrayList<String> getAttachmentIDs() {
            return this.attachmentIDs;
        }

        public DeleteAttachmentRequest(ArrayList<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "attachmentIDs");
            this.attachmentIDs = r100;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/common/CommonAttachmentPanel$PreviewAttachmentRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "attachmentIDs", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "index", "", "<init>", "(Ljava/util/ArrayList;I)V", "getAttachmentIDs", "()Ljava/util/ArrayList;", "getIndex", "()I", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PreviewAttachmentRequest implements NonProguard {
        private final ArrayList<String> attachmentIDs;
        private final int index;

        public final ArrayList<String> getAttachmentIDs() {
            return this.attachmentIDs;
        }

        public final int getIndex() {
            return this.index;
        }

        public PreviewAttachmentRequest(ArrayList<String> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "attachmentIDs");
            this.attachmentIDs = r100;
            this.index = r101;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/common/CommonAttachmentPanel$UploadAttachmentRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "attachmentID", "", "shareToken", "mountPoint", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAttachmentID", "()Ljava/lang/String;", "getShareToken", "getMountPoint", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UploadAttachmentRequest implements NonProguard {
        private final String attachmentID;
        private final String mountPoint;
        private final String shareToken;

        public final String getAttachmentID() {
            return this.attachmentID;
        }

        public final String getMountPoint() {
            return this.mountPoint;
        }

        public final String getShareToken() {
            return this.shareToken;
        }

        public UploadAttachmentRequest(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "attachmentID");
            Intrinsics.checkNotNullParameter(r101, "shareToken");
            this.attachmentID = r100;
            this.shareToken = r101;
            this.mountPoint = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/common/CommonAttachmentPanel$UploadAttachmentWithinBaseRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "attachmentID", "", "baseID", "mountPoint", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAttachmentID", "()Ljava/lang/String;", "getBaseID", "getMountPoint", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UploadAttachmentWithinBaseRequest implements NonProguard {
        private final String attachmentID;
        private final String baseID;
        private final String mountPoint;

        public final String getAttachmentID() {
            return this.attachmentID;
        }

        public final String getBaseID() {
            return this.baseID;
        }

        public final String getMountPoint() {
            return this.mountPoint;
        }

        public UploadAttachmentWithinBaseRequest(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "attachmentID");
            Intrinsics.checkNotNullParameter(r101, "baseID");
            this.attachmentID = r100;
            this.baseID = r101;
            this.mountPoint = r102;
        }
    }

    public static final class a implements NetService.c<Result<AuthCodeResult>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.jsapi.common.CommonAttachmentPanel$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/ee/bear/bitable/jsapi/common/CommonAttachmentPanel$AuthCodeResultParser$parse$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/bitable/jsapi/common/CommonAttachmentPanel$AuthCodeResult;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C3059a extends TypeToken<Result<AuthCodeResult>> {
            public C3059a() {
            }
        }

        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<AuthCodeResult> parse(String r100) {
            Intrinsics.checkNotNullParameter(r100, "json");
            Object r101 = new Gson().fromJson(r100, new C3059a().getType());     // Catch: Throwable -> L5
            Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L5
            return (Result) r101;
        L5:
            th = move-exception;
            tt5.a.e("NewLarkForm", "getUploadCode failed", th, false);
            AuthCodeResult r102 = new AuthCodeResult("");
            Result<AuthCodeResult> r103 = new Result();
            r103.code = -1;
            r103.msg = th.getMessage();
            r103.data = r102;
            return r103;
        }
    }

    public static final class b {
    }

    public interface c {
        void a(FragmentActivity r100, boolean r101, boolean r102, za5.a r103);
    }

    public interface d {
        void a(List<AttachmentInfo> r100);

        void b(int r100, String r101);
    }

    public interface e {
        void a(String r100);

        void b(int r100, String r101);
    }

    public static final class f implements za5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonAttachmentPanel f214345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f214346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f214347c;

        public static final class a<V> implements Callable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List<FileBean> f214348a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CommonAttachmentPanel f214349b;

            /* JADX WARN: Multi-variable type inference failed */
            public a(List<? extends FileBean> r100, CommonAttachmentPanel r101) {
                this.f214348a = r100;
                this.f214349b = r101;
            }

            @Override // java.util.concurrent.Callable
            public final List<AttachmentInfo> call() {
                List<FileBean> r100 = this.f214348a;
                final CommonAttachmentPanel r101 = this.f214349b;
                ArrayList r102 = new ArrayList();
                Iterator<T> r103 = r100.iterator();
            L4:
                if (r103.hasNext() == false) goto L31;
                final FileBean r104 = (FileBean) r103.next();
                int r105 = CommonAttachmentPanel.f214342c;
                r101.getClass();
                int r106 = com.bytedance.ee.bear.bitable.jsapi.common.a.f214383a;     // Catch: Throwable -> L27
                String r107 = r104.getPath();     // Catch: Throwable -> L27
                String r108 = r104.getCompressPath();     // Catch: Throwable -> L27
                String r109 = com.bytedance.ee.bear.bitable.jsapi.common.a.d(r107);     // Catch: Throwable -> L27
                if (r109 != null) goto L9;
                r109 = com.bytedance.ee.bear.bitable.jsapi.common.a.d(r108);     // Catch: Throwable -> L27
            L9:
                String r110 = r109;
                if (r110 != null) goto L12;
            L15:
                boolean r111 = true;
            L16:
                if (r111 == false) goto L18;
                tt5.a.k("NewLarkForm", "fileBean invalid because path is empty");     // Catch: Throwable -> L27
            L28:
                AttachmentInfo r112 = null;
            L29:
                if (r112 == null) goto L4;
                r102.add(r112);
                goto L4
            L18:
                Triple r113 = CommonAttachmentPanel.g(r110, null);     // Catch: Throwable -> L27
                String r114 = l0.a().toString();     // Catch: Throwable -> L27
                String r115 = r104.getMimeType();     // Catch: Throwable -> L27
                long r116 = r104.getSize();     // Catch: Throwable -> L27
                int r117 = r104.getWidth();     // Catch: Throwable -> L27
                int r118 = r104.getHeight();     // Catch: Throwable -> L27
                if (r113 == null) goto L21;
                com.bytedance.ee.bear.bitable.jsapi.common.a.C3062a r119 = CommonAttachmentPanel.m(r113);     // Catch: Throwable -> L27
            L22:
                AttachmentInfo r120 = com.bytedance.ee.bear.bitable.jsapi.common.a.a(r114, r110, r115, r116, r117, r118, r119, CommonAttachmentPanel$buildAttachmentInfo$attachmentInfo$1.INSTANCE, new CommonAttachmentPanel$buildAttachmentInfo$attachmentInfo$2(r101, r104), CommonAttachmentPanel$buildAttachmentInfo$attachmentInfo$3.INSTANCE);     // Catch: Throwable -> L27
                if (r120 == null) goto L28;
                r101.f214343a.put(r114, r120);     // Catch: Throwable -> L27
                r112 = r120;
                goto L29
            L21:
                r119 = null;
                goto L22
            L12:
                if (r110.length() == 0) goto L15;
                r111 = false;
            L27:
                tt5.a.k("NewLarkForm", "build attachment from fileBean failed");
                goto L28
            L31:
                return r102;
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                return call();
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f214350a;

            public b(d r100) {
                this.f214350a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                List<AttachmentInfo> r101 = (List) r100;
                tt5.a.h("NewLarkForm", "chooseAttachment success");
                d r102 = this.f214350a;
                if (r102 == null) goto L6;
                r102.a(r101);
                return;
            }
        }

        public static final class c<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f214351a;

            public c(d r100) {
                this.f214351a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
                tt5.a.e("NewLarkForm", "chooseAttachment failed", r101, false);
                d r102 = this.f214351a;
                if (r102 == null) goto L6;
                r102.b(BitableJSApiErrorCode.UNKNOWN.getCode(), r101.getMessage());
                return;
            }
        }

        public static final class d<V> implements Callable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List<String> f214352a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CommonAttachmentPanel f214353b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Context f214354c;

            public d(List<String> r100, CommonAttachmentPanel r101, Context r102) {
                this.f214352a = r100;
                this.f214353b = r101;
                this.f214354c = r102;
            }

            @Override // java.util.concurrent.Callable
            public final List<AttachmentInfo> call() {
                List<String> r100 = this.f214352a;
                CommonAttachmentPanel r101 = this.f214353b;
                Context r102 = this.f214354c;
                ArrayList r103 = new ArrayList();
                Iterator<T> r104 = r100.iterator();
            L4:
                if (r104.hasNext() == false) goto L49;
                String r105 = (String) r104.next();
                int r106 = CommonAttachmentPanel.f214342c;
                r101.getClass();
                if (r105.length() != 0) goto L9;
                boolean r107 = true;
            L10:
                if (r107 == false) goto L12;
                tt5.a.k("NewLarkForm", "uri attachment invalid because uri is empty");     // Catch: Throwable -> L45
            L46:
                AttachmentInfo r110 = null;
            L47:
                if (r110 == null) goto L4;
                r103.add(r110);
                goto L4
            L12:
                Uri r108 = UriProtector.parse(r105);     // Catch: Throwable -> L45
                String r111 = FileUtils.q(r102, r108);     // Catch: Throwable -> L15
            L16:
                Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L45
                com.bytedance.ee.bear.bitable.jsapi.common.a.b r112 = CommonAttachmentPanel.l(r102, r108);     // Catch: Throwable -> L45
                Triple r113 = CommonAttachmentPanel.g(r111, r108);     // Catch: Throwable -> L45
                String r114 = l0.a().toString();     // Catch: Throwable -> L45
                int r115 = com.bytedance.ee.bear.bitable.jsapi.common.a.f214383a;     // Catch: Throwable -> L45
                String r116 = r108.getLastPathSegment();     // Catch: Throwable -> L45
                String r109 = r102.getContentResolver().getType(r108);     // Catch: Throwable -> L19
            L20:
                int r117 = com.bytedance.ee.bear.bitable.jsapi.common.a.f214383a;     // Catch: Throwable -> L45
                if (r109 != null) goto L23;
            L26:
                boolean r118 = true;
            L27:
                if (r118 == false) goto L29;
            L31:
                boolean r119 = false;
            L32:
                if (r119 == true) goto L56;
                String r120 = null;
            L37:
                if (r113 == null) goto L39;
                com.bytedance.ee.bear.bitable.jsapi.common.a.C3062a r121 = CommonAttachmentPanel.m(r113);     // Catch: Throwable -> L45
            L40:
                String r122 = r111;
                String r123 = r120;
                AttachmentInfo r124 = com.bytedance.ee.bear.bitable.jsapi.common.a.b(r114, r105, r122, r116, r112, r123, r121, CommonAttachmentPanel$buildAttachmentInfo$attachmentInfo$4.INSTANCE, CommonAttachmentPanel$buildAttachmentInfo$attachmentInfo$5.INSTANCE);     // Catch: Throwable -> L45
                if (r124 == null) goto L46;
                r101.f214343a.put(r114, r124);     // Catch: Throwable -> L45
                r110 = r124;
                goto L47
            L39:
                r121 = null;
                goto L40
            L56:
                r120 = LarkUriUtil.l(r102, r108);     // Catch: Throwable -> L36
                goto L37
            L36:
                tt5.a.k("NewLarkForm", "get uri mime type failed");     // Catch: Throwable -> L45
                r120 = r109;
                goto L37
            L29:
                if (Intrinsics.areEqual(r109, "*/*") == true) goto L31;
                r119 = true;
                goto L32
            L23:
                if (r109.length() == 0) goto L26;
                r118 = false;
                goto L27
            L19:
                tt5.a.k("NewLarkForm", "get resolver mime type failed");     // Catch: Throwable -> L45
                r109 = null;
                goto L20
            L15:
                tt5.a.k("NewLarkForm", "get local path from uri failed");     // Catch: Throwable -> L45
                r111 = null;
                goto L16
            L9:
                r107 = false;
            L45:
                tt5.a.k("NewLarkForm", "build attachment from uri failed");
                goto L46
            L49:
                return r103;
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                return call();
            }
        }

        public static final class e<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f214355a;

            public e(d r100) {
                this.f214355a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                List<AttachmentInfo> r101 = (List) r100;
                tt5.a.h("NewLarkForm", "chooseAttachment uri success");
                d r102 = this.f214355a;
                if (r102 == null) goto L6;
                r102.a(r101);
                return;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.jsapi.common.CommonAttachmentPanel$f$f, reason: collision with other inner class name */
        public static final class C3060f<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f214356a;

            public C3060f(d r100) {
                this.f214356a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
                tt5.a.e("NewLarkForm", "chooseAttachment uri failed", r101, false);
                d r102 = this.f214356a;
                if (r102 == null) goto L6;
                r102.b(BitableJSApiErrorCode.UNKNOWN.getCode(), r101.getMessage());
                return;
            }
        }

        @Override // za5.a
        public final void b() {
            tt5.a.b("NewLarkForm", "onSelectFileCancel");
            d r100 = this.f214346b;
            if (r100 == null) goto L6;
            r100.a(null);
            return;
        }

        @Override // za5.a
        public final void c(List<? extends FileBean> r100) {
            Intrinsics.checkNotNullParameter(r100, "fileList");
            Flowable r101 = Flowable.fromCallable(new a(r100, this.f214345a)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d());
            d r102 = this.f214346b;
            r101.subscribe(new b(r102), new c(r102));
        }

        @Override // za5.a
        public final void a(List<String> r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "filePointerList");
            tt5.a.b("NewLarkForm", "onSelectFileList count=" + ((ArrayList) r100).size() + " isFileUseUri=" + r101);
            if (r101 == false) goto L6;
            Flowable r102 = Flowable.fromCallable(new d(r100, this.f214345a, this.f214347c)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d());
            d r103 = this.f214346b;
            r102.subscribe(new e(r103), new C3060f(r103));
            return;
        }

        public f(CommonAttachmentPanel r100, d r101, Context r102) {
            this.f214345a = r100;
            this.f214346b = r101;
            this.f214347c = r102;
        }
    }

    public static final class g<T> implements FlowableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g<T> f214357a = null;

        public static final class a implements com.bytedance.ee.bear.lark.dependency.h.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowableEmitter<Boolean> f214358a;

            @Override // com.bytedance.ee.bear.lark.dependency.h.a
            public final void a() {
                tt5.a.h("NewLarkForm", "docSdk init success");
                ((com.bytedance.ee.bear.lark.dependency.h) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.h.class, null, null, 6)).c();
                this.f214358a.onNext(Boolean.TRUE);
                this.f214358a.onComplete();
            }

            public a(FlowableEmitter<Boolean> r100) {
                this.f214358a = r100;
            }
        }

        static {
            f214357a = new g();
        }

        public g() {
        }

        @Override // io.reactivex.FlowableOnSubscribe
        public final void subscribe(FlowableEmitter<Boolean> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            com.bytedance.ee.bear.lark.dependency.h r101 = (com.bytedance.ee.bear.lark.dependency.h) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.h.class, null, null, 6);
            tt5.a.h("NewLarkForm", "docSdk init begin");
            r101.b(new a(r100));
            r101.a();
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f214359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList<BaseOpenEntity> f214360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PreviewAttachmentRequest f214361c;

        public h(Activity r100, ArrayList<BaseOpenEntity> r101, PreviewAttachmentRequest r102) {
            this.f214359a = r100;
            this.f214360b = r101;
            this.f214361c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L5;
            ((com.bytedance.ee.bear.i) org.koin.java.a.c(com.bytedance.ee.bear.i.class, null, null, 6)).h(this.f214359a, this.f214360b, this.f214361c.getIndex());
            return;
        L5:
            tt5.a.h("NewLarkForm", "docSdk init failed");
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i<T> f214362a = null;

        static {
            f214362a = new i();
        }

        public i() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e("NewLarkForm", "preview failed", (Throwable) r100, false);
        }
    }

    public static final class j<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f214363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f214364b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AttachmentInfo f214365c;

        public j(String r100, String r101, AttachmentInfo r102) {
            this.f214363a = r100;
            this.f214364b = r101;
            this.f214365c = r102;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((String) r100, "it");
            tt5.a.h("NewLarkForm", "get uploadCode begin");
            NetService.f r101 = new NetService.f("/api/bitable/external/share/uploadCode");
            String r102 = this.f214363a;
            String r103 = this.f214364b;
            AttachmentInfo r104 = this.f214365c;
            r101.f216906c = 2;
            r101.b("shareToken", r102);
            r101.b("mountPoint", r103);
            r101.b("fileName", r104.getName());
            r101.b("size", String.valueOf(r104.getSize()));
            NetService r105 = null;
            r105 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);     // Catch: Throwable -> L5
        L7:
            if (r105 == null) goto L10;
            return r105.Vc(new a()).a(r101).map(com.bytedance.ee.bear.bitable.jsapi.common.k.f214416a);
        L10:
            return Flowable.create(com.bytedance.ee.bear.bitable.jsapi.common.l.f214417a, BackpressureStrategy.BUFFER).timeout(5000, TimeUnit.MILLISECONDS).flatMap(new n(r101));
        L5:
            th = move-exception;
            tt5.a.e("NewLarkForm", "NetService not ready", th, false);
            goto L7
        }
    }

    public static final class k<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachmentInfo f214366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CommonAttachmentPanel f214367b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f214368c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f214369d;

        public k(AttachmentInfo r100, CommonAttachmentPanel r101, String r102, e r103) {
            this.f214366a = r100;
            this.f214367b = r101;
            this.f214368c = r102;
            this.f214369d = r103;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r110) {
            AuthCodeResult r100 = (AuthCodeResult) r110;
            Intrinsics.checkNotNullParameter(r100, "result");
            tt5.a.h("NewLarkForm", "get uploadCode success code=" + r100.getUploadCode());
            DrivePriority$UploadPriority.DEFAULT.getPriority();
            UploadRequestInfo.UploadType r111 = UploadRequestInfo.UploadType.DRIVE;
            LinkedHashMap r112 = new LinkedHashMap();
            r112.put("size_checker", "true");
            if (TextUtils.isEmpty(this.f214366a.getUri()) == true) goto L6;
            String r101 = this.f214366a.getUri();
            String r102 = "";
        L9:
            String r113 = r100.getUploadCode();
            String r103 = this.f214366a.getName();
            int r114 = DrivePriority$UploadPriority.USER_INTERACTION.getPriority();
            final e r104 = this.f214369d;
            UploadRequestInfo r105 = new UploadRequestInfo(r102, r101, r103, "", "bitable_file", r113, r114, r111, null, r112, null, new CommonAttachmentPanel$uploadAttachmentWithShareToken$1$2$info$1(r104));
            tt5.a.h("NewLarkForm", "upload begin");
            this.f214367b.f214344b.put(this.f214368c, ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.c(com.bytedance.ee.bear.drive.sdk.service.f.class, null, null, 6)).d0().s(r105));
            return Unit.INSTANCE;
        L6:
            if (TextUtils.isEmpty(this.f214366a.getPath()) == true) goto L8;
            r102 = this.f214366a.getPath();
            r101 = "";
            goto L9
        L8:
            tt5.a.d("NewLarkForm", "invalid attachmentInfo uri and path are empty");
            Unit r106 = Unit.INSTANCE;
            r102 = "";
            r101 = r102;
            goto L9
        }
    }

    public static final class l<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l<T> f214370a = null;

        static {
            f214370a = new l();
        }

        public l() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Unit r101 = (Unit) r100;
            tt5.a.h("NewLarkForm", "startUpload success");
        }
    }

    public static final class m<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f214371a;

        public m(e r100) {
            this.f214371a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.d("NewLarkForm", "startUpload fail: " + r101);
            int r102 = com.bytedance.ee.bear.bitable.c.f207079a;
            int r103 = com.bytedance.ee.bear.bitable.n.f214744a;
            if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.field.attach_upload_report_message") == false) goto L5;
            String r104 = r101.toString();
        L6:
            e r105 = this.f214371a;
            if (r105 == null) goto L10;
            r105.b(BitableJSApiErrorCode.UPLOAD_ERROR_WITH_SHARE_TOKEN.getCode(), r104);
            return;
        L10:
            return;
        L5:
            r104 = r101.getMessage();
            goto L6
        }
    }

    static {
    }

    public CommonAttachmentPanel() {
        this.f214343a = new LinkedHashMap();
        this.f214344b = new LinkedHashMap();
    }

    public static Triple f(VFSPath r110) {
        Intrinsics.checkNotNullParameter(r110, "path");
        InputStream r100 = ay4.d.a().l(r110);     // Catch: Throwable -> L51
    L49:
        th = move-exception;
        Throwable th10 = th;
        InputStream r111 = null;
    L78:
        tt5.a.e("NewLarkForm", "encodeBitmapToBase64 failed", th10, false);     // Catch: Throwable -> L63
        if (r100 != null) goto L81;
    L58:
        if (r111 == null) goto L62;
        r111.close();     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        tt5.a.e("NewLarkForm", "close inputStream failed", th, false);
    L62:
        return null;
    L81:
        r100.close();     // Catch: Throwable -> L56
    L63:
        th = move-exception;
        if (r100 != null) goto L85;
    L68:
        if (r111 == null) goto L72;
        r111.close();     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        tt5.a.e("NewLarkForm", "close inputStream failed", th, false);
    L72:
        throw th;
    L85:
        r100.close();     // Catch: Throwable -> L66
        goto L68
    L5:
        if (r100.markSupported() == false) goto L7;
        r100.mark(0);     // Catch: Throwable -> L49
    L8:
        BitmapFactory.Options r101 = new BitmapFactory.Options();     // Catch: Throwable -> L49
        int r102 = 1;
        r101.inJustDecodeBounds = true;     // Catch: Throwable -> L49
        BitmapFactory.decodeStream(r100, null, r101);     // Catch: Throwable -> L49
        if (r101.outHeight > 0) goto L17;
        tt5.a.h("NewLarkForm", "is not image options=" + r101);     // Catch: Throwable -> L49
        r100.close();     // Catch: Throwable -> L13
    L15:
        return null;
    L13:
        th = move-exception;
        tt5.a.e("NewLarkForm", "close inputStream failed", th, false);
        goto L15
    L17:
        if (r100.markSupported() == false) goto L19;
        r100.reset();     // Catch: Throwable -> L49
        r111 = r100;
    L77:
        int r103 = r101.outHeight;     // Catch: Throwable -> L47
        int r104 = r101.outWidth;     // Catch: Throwable -> L47
        if (r103 > 256) goto L23;
        if (r104 > 256) goto L23;
    L29:
        r101.inJustDecodeBounds = false;     // Catch: Throwable -> L47
        r101.inSampleSize = r102;     // Catch: Throwable -> L47
        Bitmap r105 = BitmapFactory.decodeStream(r111, null, r101);     // Catch: Throwable -> L47
        if (r105 == null) goto L39;
        Integer r106 = Integer.valueOf(r101.outWidth);     // Catch: Throwable -> L47
        Integer r107 = Integer.valueOf(r101.outHeight);     // Catch: Throwable -> L47
        Bitmap.CompressFormat r108 = Bitmap.CompressFormat.JPEG;     // Catch: Throwable -> L47
        ByteArrayOutputStream r112 = new ByteArrayOutputStream();     // Catch: Throwable -> L47
        r105.compress(r108, 100, r112);     // Catch: Throwable -> L47
        Triple r109 = new Triple(r106, r107, Base64.encodeToString(r112.toByteArray(), 0));     // Catch: Throwable -> L47
        r100.close();     // Catch: Throwable -> L36
        if (r111 == null) goto L38;
        r111.close();     // Catch: Throwable -> L36
    L38:
        return r109;
    L36:
        th = move-exception;
        tt5.a.e("NewLarkForm", "close inputStream failed", th, false);
        goto L38
    L39:
        tt5.a.k("NewLarkForm", "decodeBitmap failed");     // Catch: Throwable -> L47
        r100.close();     // Catch: Throwable -> L44
        if (r111 == null) goto L46;
        r111.close();     // Catch: Throwable -> L44
    L46:
        return null;
    L44:
        th = move-exception;
        tt5.a.e("NewLarkForm", "close inputStream failed", th, false);
    L23:
        int r113 = r103 / 2;     // Catch: Throwable -> L47
        int r114 = r104 / 2;     // Catch: Throwable -> L47
    L25:
        if ((r113 / r102) < 256) goto L29;
        if ((r114 / r102) < 256) goto L29;
        r102 = r102 * 2;     // Catch: Throwable -> L47
    L47:
        th10 = th;
        goto L78
    L19:
        r111 = ay4.d.a().l(r110);     // Catch: Throwable -> L49
        goto L77
    L7:
        tt5.a.k("NewLarkForm", "is not support mark");     // Catch: Throwable -> L49
    L51:
        th = move-exception;
        th10 = th;
        r111 = null;
        r100 = null;
        goto L78
    }

    public static com.bytedance.ee.bear.bitable.jsapi.common.a.C3062a m(Triple r100) {
        return new com.bytedance.ee.bear.bitable.jsapi.common.a.C3062a(((Number) r100.getFirst()).intValue(), ((Number) r100.getSecond()).intValue(), (String) r100.getThird());
    }

    public final List<AttachmentCheckedInfo> a(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "attachmentIds");
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = (String) r102.next();
        r101.add(new AttachmentCheckedInfo(r103, this.f214343a.containsKey(r103)));
        goto L4
    L6:
        return r101;
    }

    public final void e(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "attachmentIds");
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        String r102 = (String) r101.next();
        this.f214343a.remove(r102);
        goto L4
    }

    public static ParcelFileDescriptor c(ContentResolver r210, Uri r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, "r"};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r111[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r111;
        f06.d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r210, r101, "android.os.ParcelFileDescriptor", r110);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r210, r211, "r");
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r111 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Cursor d(ContentResolver r110, Uri r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, null, null, null, null};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r112, false);
        return (Cursor) r113.f474983b;
    L6:
        Cursor r114 = r110.query(r111, null, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r114, r112, true);
        return r114;
    }

    public static Triple g(String r100, Uri r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L22;
    L14:
        if (r101 == null) goto L24;
        return f(ay4.d.a().q(r101));
    L17:
        tt5.a.k("NewLarkForm", "generate image info from uri failed");
        return null;
    L24:
        return null;
    L22:
        Triple r103 = f(ay4.d.a().z(r100));     // Catch: Throwable -> L13
        if (r103 == null) goto L14;
        return r103;
    L13:
        tt5.a.k("NewLarkForm", "generate image info from path failed");
        goto L14
    L4:
        if (r100.length() == 0) goto L7;
        r102 = false;
        goto L9
    }

    public static long h(Context r110, Uri r111) {
        InputStream r100 = null;
        AssetFileDescriptor r101 = ContentResolverWrapper.openAssetFileDescriptor(r110.getContentResolver(), r111, "r");     // Catch: Throwable -> L14
        if (r101 != null) goto L76;
    L12:
        if (r101 != null) goto L86;
    L82:
        ParcelFileDescriptor r102 = c(r110.getContentResolver(), r111);     // Catch: Throwable -> L29
        if (r102 != null) goto L84;
    L27:
        if (r102 == null) goto L88;
    L68:
        r102.close();     // Catch: Throwable -> L34
    L34:
        tt5.a.k("NewLarkForm", "close uri fd failed");
    L88:
        r100 = ContentResolverWrapper.openInputStream(r110.getContentResolver(), r111);     // Catch: Throwable -> L42
        if (r100 == null) goto L40;
        long r112 = r100.available();     // Catch: Throwable -> L42
        r100.close();
        return r112;
    L40:
        if (r100 != null) goto L70;
    L47:
        return 0;
    L70:
        r100.close();     // Catch: Throwable -> L46
    L46:
        tt5.a.k("NewLarkForm", "close uri stream failed");
    L42:
        tt5.a.k("NewLarkForm", "get uri file size from stream failed");     // Catch: Throwable -> L48
        if (r100 == null) goto L47;
    L48:
        th = move-exception;
        if (r100 != null) goto L78;
    L53:
        throw th;
    L78:
        r100.close();     // Catch: Throwable -> L52
    L52:
        tt5.a.k("NewLarkForm", "close uri stream failed");
        goto L53
    L84:
        long r103 = r102.getStatSize();     // Catch: Throwable -> L66
        if (r103 <= 0) goto L27;
        r102.close();
        return r103;
    L80:
        tt5.a.k("NewLarkForm", "get uri file size from fd failed");     // Catch: Throwable -> L54
        if (r102 == null) goto L88;
    L54:
        th = move-exception;
        if (r102 != null) goto L90;
    L59:
        throw th;
    L90:
        r102.close();     // Catch: Throwable -> L58
    L58:
        tt5.a.k("NewLarkForm", "close uri fd failed");
    L29:
        r102 = null;
    L86:
        r101.close();     // Catch: Throwable -> L19
    L19:
        tt5.a.k("NewLarkForm", "close uri asset fd failed");
        goto L82
    L76:
        long r104 = r101.getDeclaredLength();     // Catch: Throwable -> L67
        if (r104 == (-1)) goto L12;
        if (r104 <= 0) goto L12;
        r101.close();
        return r104;
    L92:
        tt5.a.k("NewLarkForm", "get uri file size from asset fd failed");     // Catch: Throwable -> L60
        if (r101 == null) goto L82;
    L60:
        th = move-exception;
        if (r101 != null) goto L72;
    L65:
        throw th;
    L72:
        r101.close();     // Catch: Throwable -> L64
    L64:
        tt5.a.k("NewLarkForm", "close uri asset fd failed");
    L14:
        r101 = null;
        goto L92
    }

    public static com.bytedance.ee.bear.bitable.jsapi.common.a.b l(Context r110, Uri r111) {
        int r100 = 1;
        Cursor r101 = null;
        String r102 = null;
        r102 = null;
        Cursor r103 = d(r110.getContentResolver(), r111);     // Catch: Throwable -> L42
        if (r103 != null) goto L48;
    L8:
        boolean r104 = false;
    L9:
        if (r104 == false) goto L26;
        int r105 = r103.getColumnIndex("_size");     // Catch: Throwable -> L31
        if (r105 >= 0) goto L13;
    L15:
        long r106 = 0;
    L16:
        int r112 = r103.getColumnIndex("_display_name");     // Catch: Throwable -> L31
        if (r112 < 0) goto L22;
        if (r103.isNull(r112) == true) goto L22;
        r102 = r103.getString(r112);     // Catch: Throwable -> L31
    L22:
        if (r106 > 0) goto L25;
        r106 = h(r110, r111);     // Catch: Throwable -> L31
    L25:
        com.bytedance.ee.bear.bitable.jsapi.common.a.b r107 = new com.bytedance.ee.bear.bitable.jsapi.common.a.b(r102, r106);     // Catch: Throwable -> L31
    L27:
        if (r103 == null) goto L35;
        r103.close();     // Catch: Throwable -> L30
    L45:
    L35:
        return r107;
    L13:
        if (r103.isNull(r105) == true) goto L15;
        r106 = r103.getLong(r105);     // Catch: Throwable -> L31
        goto L16
    L26:
        tt5.a.k("NewLarkForm", "query uri metadata failed because cursor is empty");     // Catch: Throwable -> L31
        r107 = new com.bytedance.ee.bear.bitable.jsapi.common.a.b(h(r110, r111), r100);     // Catch: Throwable -> L31
        goto L27
    L48:
    L31:
        r101 = r103;
        goto L50
    L6:
        if (r103.moveToFirst() != true) goto L8;
        r104 = true;
    L30:
        tt5.a.k("NewLarkForm", "close uri metadata cursor failed");
    L50:
        tt5.a.k("NewLarkForm", "query uri metadata failed");     // Catch: Throwable -> L36
        r107 = new com.bytedance.ee.bear.bitable.jsapi.common.a.b(h(r110, r111), r100);     // Catch: Throwable -> L36
        if (r101 == null) goto L35;
        r101.close();     // Catch: Throwable -> L30
    L36:
        th = move-exception;
        if (r101 != null) goto L43;
    L41:
        throw th;
    L43:
        r101.close();     // Catch: Throwable -> L40
    L40:
        tt5.a.k("NewLarkForm", "close uri metadata cursor failed");
        goto L41
    }

    public final void k(Activity r110, PreviewAttachmentRequest r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r210, "request");
        ArrayList<? extends BaseOpenEntity> r100 = new ArrayList();
        ArrayList<String> r101 = r210.getAttachmentIDs();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L3:
        com.bytedance.ee.bear.i r104 = null;
        LocalOpenEntity r105 = null;
        r105 = null;
        if (r103.hasNext() == false) goto L19;
        String r106 = (String) r103.next();
        AttachmentInfo r107 = (AttachmentInfo) ((LinkedHashMap) this.f214343a).get(r106);
        if (r107 == null) goto L17;
        String r108 = r107.getPath();
        if (r108 != null) goto L12;
        r108 = r107.getUri();
        if (r108 != null) goto L12;
        r108 = "";
    L12:
        String r111 = r108;
        if (TextUtils.isEmpty(r111) == true) goto L15;
        r105 = new LocalOpenEntity("26_local", null, null, r107.getName(), null, new ArrayList(), r111);
        r105.setUseLarkPreview(r211);
        goto L17
    L15:
        tt5.a.k("NewLarkForm", "attachment path invalid");
    L17:
        if (r105 == null) goto L3;
        r102.add(r105);
        goto L3
    L19:
        CollectionsKt.toCollection(r102, r100);
        r104 = (com.bytedance.ee.bear.i) org.koin.java.a.c(com.bytedance.ee.bear.i.class, null, null, 6);     // Catch: Throwable -> L22
    L24:
        if (r104 == null) goto L26;
        r104.h(r110, r100, r210.getIndex());
        return;
    L26:
        Flowable.create(g.f214357a, BackpressureStrategy.BUFFER).subscribeOn(fo5.d.b()).timeout(5000, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).subscribe(new h(r110, r100, r210), i.f214362a);
        return;
    L22:
        th = move-exception;
        tt5.a.e("NewLarkForm", "previewService not ready", th, false);
        goto L24
    }

    public final void n(String r100, String r101, String r102, e r103) {
        Intrinsics.checkNotNullParameter(r100, "attachmentId");
        Intrinsics.checkNotNullParameter(r101, "shareToken");
        AttachmentInfo r104 = (AttachmentInfo) ((LinkedHashMap) this.f214343a).get(r100);
        if (r104 == null) goto L6;
        tt5.a.h("NewLarkForm", "uploadWithinShareToken begin size=" + r104.getSize());
        Flowable.just("").subscribeOn(fo5.d.b()).flatMap(new j(r101, r102, r104)).map(new k(r104, this, r100, r103)).observeOn(fo5.d.d()).subscribe(l.f214370a, new m(r103));
        return;
    L6:
        tt5.a.h("NewLarkForm", "uploadAttachmentWithShareToken failed " + r100 + " without attachmentInfo");
        BitableJSApiErrorCode r105 = BitableJSApiErrorCode.UPLOAD_ERROR_WITH_SHARE_TOKEN_NO_ATTACHMENT;
        r103.b(r105.getCode(), r105.getErrMsg());
    }

    public final void o(String r110, String r111, String r210, final e r211) {
        Intrinsics.checkNotNullParameter(r110, "attachmentId");
        Intrinsics.checkNotNullParameter(r111, "baseID");
        AttachmentInfo r100 = (AttachmentInfo) ((LinkedHashMap) this.f214343a).get(r110);
        if (r100 == null) goto L13;
        DrivePriority$UploadPriority.DEFAULT.getPriority();
        UploadRequestInfo.UploadType r112 = UploadRequestInfo.UploadType.DRIVE;
        if (TextUtils.isEmpty(r100.getUri()) == true) goto L8;
        String r101 = r100.getUri();
        String r102 = "";
    L11:
        String r103 = String.valueOf(((t) org.koin.java.a.c(t.class, null, null, 6)).e());
        HashMap r113 = new HashMap();
        r113.put("size_checker", r103);
        this.f214344b.put(r110, ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.c(com.bytedance.ee.bear.drive.sdk.service.f.class, null, null, 6)).d0().s(new UploadRequestInfo(r102, r101, r100.getName(), r111, r210, "", DrivePriority$UploadPriority.USER_INTERACTION.getPriority(), r112, null, r113, null, new CommonAttachmentPanel$uploadAttachmentWithinBase$1$uploadInfoBuilder$1(r211))));
        return;
    L8:
        if (TextUtils.isEmpty(r100.getPath()) == true) goto L10;
        r102 = r100.getPath();
        r101 = "";
        goto L11
    L10:
        tt5.a.d("NewLarkForm", "invalid attachmentInfo uri and path are empty");
        Unit r104 = Unit.INSTANCE;
        r102 = "";
        r101 = r102;
        goto L11
    L13:
        tt5.a.h("NewLarkForm", "uploadAttachmentWithinBase failed " + r110 + " without attachmentInfo");
        BitableJSApiErrorCode r105 = BitableJSApiErrorCode.UPLOAD_ERROR_WITH_BASE_TOKEN_NO_ATTACHMENT;
        r211.b(r105.getCode(), r105.getErrMsg());
    }

    public static void i(Context r100, Integer r101, Integer r102, za5.a r103, bb5.c r104) {
        if ((r100 instanceof FragmentActivity) == true) goto L6;
        tt5.a.d("NewLarkForm", "open album failed ctx is invalid");
        return;
    L6:
        FileSelectConfig.g r105 = FileSelectConfig.fullScreenAlbumBuilder();
        FileSelectConfig r106 = r105.f226780a;
        r106.fileSelectListener = r103;
        r106.fileCheckListener = r104;
        r106.sourceType = 0;
        r106.checkedKeepOrigin = true;
        r106.isOriginFile = true;
        r106.showGif = true;
        r106.enableImageCompress = true;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.bitable.forms.image_maxsize.enable") == false) goto L9;
        r105.f226780a.maxImageCompressSize = 20971520;
    L9:
        if (r101 == null) goto L11;
        r105.f226780a.maxSelectImageNum = r101.intValue();
    L11:
        if (r102 == null) goto L13;
        r105.f226780a.mediaType = r102.intValue();
    L13:
        int r107 = com.bytedance.ee.bear.fileselector.d.f226786a;
        com.bytedance.ee.bear.fileselector.d.a.c(r100, ((FragmentActivity) r100).getSupportFragmentManager(), r105.a(), "NewLarkForm");
    }

    public static void j(Context r100, boolean r101, boolean r102, za5.a r103, c r104) {
        if ((r100 instanceof FragmentActivity) == true) goto L6;
        tt5.a.d("NewLarkForm", "show camera failed ctx is invalid");
        return;
    L6:
        if (r104 == null) goto L9;
        r104.a((FragmentActivity) r100, r101, r102, r103);
        return;
    L9:
        FileSelectConfig.h r105 = FileSelectConfig.larkCamaraBuilder();
        FileSelectConfig r106 = r105.f226780a;
        r106.fileSelectListener = r103;
        r106.showTakePhoto = r101;
        r106.showTakeVideo = r102;
        r106.camaraUse1080P = true;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.bitable.forms.image_maxsize.enable") == false) goto L12;
        r105.f226780a.maxImageCompressSize = 20971520;
    L12:
        int r107 = com.bytedance.ee.bear.fileselector.d.f226786a;
        com.bytedance.ee.bear.fileselector.d.a.c(r100, ((FragmentActivity) r100).getSupportFragmentManager(), r105.a(), "NewLarkForm");
    }

    public final void b(Context r110, ChooseAttachmentRequest r111, d r112, bb5.c r210, bb5.h r211, c r212) {
        Intrinsics.checkNotNullParameter(r110, "ctx");
        Intrinsics.checkNotNullParameter(r111, "request");
        f r113 = new f(this, r112, r110);
        String[] r100 = r111.getMediaType();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L11:
        boolean r102 = true;
    L13:
        if (r102 == false) goto L15;
        boolean r114 = true;
        boolean r115 = true;
    L25:
        if (Intrinsics.areEqual(r111.getMode(), "onlyCamera") == false) goto L28;
        j(r110, r114, r115, r113, r212);
        return;
    L28:
        if (r114 == false) goto L31;
        if (r115 == false) goto L31;
    L35:
        int r103 = 2;
    L37:
        if (Intrinsics.areEqual(r111.getMode(), "onlyAlbum") == false) goto L39;
        i(r110, r111.getCount(), Integer.valueOf(r103), r113, r210);
        return;
    L39:
        String[] r116 = r111.getAcceptFileTypes();
        if (r116 != null) goto L42;
    L46:
        Integer r117 = r111.getCount();
        Integer r118 = Integer.valueOf(r103);
        Boolean r104 = Boolean.valueOf(r101);
        com.bytedance.ee.bear.widgets.a r119 = new com.bytedance.ee.bear.widgets.a(r110);
        if (Intrinsics.areEqual(r104, Boolean.TRUE) == true) goto L49;
    L51:
        String r105 = r110.getString(R.string.Bitable_Attachment_UploadMethod);
    L52:
        r119.k(r105);
        r119.e(R.string.Bitable_Attachment_Camera, new com.bytedance.ee.bear.bitable.jsapi.common.e(r118, this, r110, r113, r212));
        r119.e(R.string.Bitable_Attachment_Photo, new com.bytedance.ee.bear.bitable.jsapi.common.f(this, r110, r117, r118, r113, r210));
        r119.e(R.string.Bitable_Attachment_LocalFile, new com.bytedance.ee.bear.bitable.jsapi.common.g(this, r110, r113, r210));
        r119.b(com.bytedance.ee.bear.bitable.jsapi.common.h.f214413a);
        com.bytedance.ee.bear.bitable.jsapi.common.i r106 = com.bytedance.ee.bear.bitable.jsapi.common.i.f214414a;
        r119.f240136b.f284132c.onCancelListener(r106);
        r119.p(new com.bytedance.ee.bear.bitable.jsapi.common.j(r211));
        r119.q();
        return;
    L49:
        if (com.bytedance.ee.bear.bitable.c.m() == false) goto L51;
        r105 = r110.getString(R.string.Bitabe_DB_AttachmentField_OnlyPhotosAndVideosAllowed_Desc_Mob);
        goto L52
    L42:
        if (ArraysKt.contains(r116, "image") == false) goto L44;
    L45:
        r101 = true;
        goto L46
    L44:
        if (ArraysKt.contains(r116, "video") == false) goto L46;
    L31:
        if (r114 == false) goto L33;
        r103 = 0;
        goto L37
    L33:
        if (r115 == false) goto L35;
        r103 = 1;
        goto L37
    L15:
        String[] r107 = r111.getMediaType();
        int r108 = r107.length;
        int r120 = 0;
        r114 = false;
        r115 = false;
    L16:
        if (r120 >= r108) goto L25;
        String r121 = r107[r120];
        if (Intrinsics.areEqual(r121, "image") == false) goto L21;
        r114 = true;
    L23:
        r120 = r120 + 1;
        goto L16
    L21:
        if (Intrinsics.areEqual(r121, "video") == false) goto L23;
        r115 = true;
        goto L23
    L5:
        if (r100.length != 0) goto L7;
        boolean r109 = true;
    L8:
        if (r109 == true) goto L11;
        r102 = false;
        goto L13
    L7:
        r109 = false;
        goto L8
    }
}
