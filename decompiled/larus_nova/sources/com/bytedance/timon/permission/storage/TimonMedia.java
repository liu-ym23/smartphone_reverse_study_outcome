package com.bytedance.timon.permission.storage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.provider.MediaStore;
import androidx.core.content.ContextCompat;
import bytedance.io.BdMediaItem;
import bytedance.util.BdFileUtils;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.bytedance.timon.permission.storage.constant.MediaPermissionResult;
import com.bytedance.timon.permission.storage.constant.MediaPickType;
import com.bytedance.timon.permission.storage.constant.ResultCode;
import com.bytedance.timon.permission.storage.constant.TimonMediaType;
import com.bytedance.timon.permission.storage.manager.TimonMediaInternal;
import com.bytedance.timon.permission.storage.manager.TimonMediaManager;
import com.bytedance.timon.permission.storage.util.b;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.bduploader.BDVideoUploaderBase;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001HB\t\b\u0002¢\u0006\u0004\bF\u0010GJ.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J:\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\bH\u0007J:\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\bH\u0007J&\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\bH\u0007J&\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\bH\u0007J.\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\bH\u0007J.\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\bH\u0007J&\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\bH\u0007J&\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\bH\u0007J.\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\bH\u0007J.\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\bH\u0007J&\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\bH\u0007J-\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\bH\u0001¢\u0006\u0004\b\u0019\u0010\u001aJF\u0010!\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0 0\bH\u0007JF\u0010!\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0 0\bH\u0007J4\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0 0\bH\u0007J4\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0 0\bH\u0007J\u0091\u0001\u0010.\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\t2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010$2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010$2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010)\u001a\u00020\u001d2\b\b\u0002\u0010*\u001a\u00020\u001d2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020-0\bH\u0007¢\u0006\u0004\b.\u0010/J\u0091\u0001\u0010.\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\t2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010$2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010$2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010)\u001a\u00020\u001d2\b\b\u0002\u0010*\u001a\u00020\u001d2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020-0\bH\u0007¢\u0006\u0004\b.\u00100J[\u0010.\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\t2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010$2\u0006\u00102\u001a\u0002012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020-0\bH\u0007¢\u0006\u0004\b.\u00103J[\u0010.\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\t2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010$2\u0006\u00102\u001a\u0002012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020-0\bH\u0007¢\u0006\u0004\b.\u00104J{\u00106\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010$2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010)\u001a\u00020\u001d2\b\b\u0002\u0010*\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050 0\bH\u0007¢\u0006\u0004\b6\u00107J{\u00106\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010$2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010)\u001a\u00020\u001d2\b\b\u0002\u0010*\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050 0\bH\u0007¢\u0006\u0004\b6\u00108J\"\u00109\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\"\u00109\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0007J6\u0010<\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000b0:H\u0007J6\u0010<\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000b0:H\u0007J>\u0010=\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000b0:H\u0007J>\u0010=\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000b0:H\u0007J\u0016\u0010B\u001a\u00020A2\u0006\u0010?\u001a\u00020>2\u0006\u0010\u0010\u001a\u00020@J\u0017\u0010E\u001a\u00020\u00112\u0006\u0010?\u001a\u00020>H\u0000¢\u0006\u0004\bC\u0010D¨\u0006I"}, d2 = {"Lcom/bytedance/timon/permission/storage/TimonMedia;", "", "Landroid/app/Activity;", "activity", "Lah7/a;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "", TextureRenderKeys.KEY_IS_CERT, "Lxg7/a;", "Landroid/net/Uri;", "callback", "", "insertAlbum", "Lcom/bytedance/timon/permission/storage/TimonMedia$ExtraInfo;", "info", "Lcom/bytedance/timon/permission/storage/constant/MediaPickType;", "type", "", PriorityModule.SCENE_MULTI, "Landroid/content/Intent;", "pickMedia", "takePhoto", "intent", "takeVideo", "takeAudio", "takeAudio$permission_keeper_storage_release", "(Landroid/app/Activity;Lcom/bytedance/timon/permission/storage/TimonMedia$ExtraInfo;Lxg7/a;)V", "Ljava/io/File;", MapBundleKey.MapObjKey.OBJ_DIR, "", "count", "onlyNew", "", "getNewFiles", "getLatestPictures", "uri", "", "projection", "selection", "selectionArgs", "sortOrder", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "offset", "Landroid/os/CancellationSignal;", "cancellationSignal", "Landroid/database/Cursor;", "query", "(Landroid/app/Activity;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;IILandroid/os/CancellationSignal;Ljava/lang/String;Lxg7/a;)V", "(Landroid/app/Activity;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;IILandroid/os/CancellationSignal;Lcom/bytedance/timon/permission/storage/TimonMedia$ExtraInfo;Lxg7/a;)V", "Landroid/os/Bundle;", "queryArgs", "(Landroid/app/Activity;Landroid/net/Uri;[Ljava/lang/String;Landroid/os/Bundle;Landroid/os/CancellationSignal;Ljava/lang/String;Lxg7/a;)V", "(Landroid/app/Activity;Landroid/net/Uri;[Ljava/lang/String;Landroid/os/Bundle;Landroid/os/CancellationSignal;Lcom/bytedance/timon/permission/storage/TimonMedia$ExtraInfo;Lxg7/a;)V", "Lbytedance/io/BdMediaItem;", "queryMedia", "(Landroid/app/Activity;Lcom/bytedance/timon/permission/storage/constant/MediaPickType;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Lxg7/a;)V", "(Landroid/app/Activity;Lcom/bytedance/timon/permission/storage/constant/MediaPickType;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;IILcom/bytedance/timon/permission/storage/TimonMedia$ExtraInfo;Lxg7/a;)V", "convertUriToPath", "Lkotlin/Function0;", "block", "withWritePermission", "withReadPermission", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/timon/permission/storage/constant/TimonMediaType;", "Lcom/bytedance/timon/permission/storage/constant/MediaPermissionResult;", "checkReadMediaPermission", "checkWriteMediaPermission$permission_keeper_storage_release", "(Landroid/content/Context;)Z", "checkWriteMediaPermission", "<init>", "()V", "ExtraInfo", "permission-keeper-storage_release"}, k = 1, mv = {1, 7, 1})
public final class TimonMedia {
    public static final TimonMedia INSTANCE = null;

    public static final class ExtraInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f270639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f270640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f270641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f270642d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f270643e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Function1<? super String[], Unit> f270644f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Function3<? super Boolean, ? super String[], ? super String[], Unit> f270645g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Function1<? super String[], Unit> f270646h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f270647i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f270648j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Map<String, String> f270649k;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ExtraInfo) == true) goto L8;
            return false;
        L8:
            ExtraInfo r101 = (ExtraInfo) r100;
            if (Intrinsics.areEqual(this.f270639a, r101.f270639a) == true) goto L12;
            return false;
        L12:
            if (this.f270640b == r101.f270640b) goto L15;
            return false;
        L15:
            if (this.f270641c == r101.f270641c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f270642d, r101.f270642d) == true) goto L21;
            return false;
        L21:
            if (this.f270643e == r101.f270643e) goto L23;
            return false;
        L23:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public final int hashCode() {
            int r100 = this.f270639a.hashCode() * 31;
            boolean r101 = this.f270640b;
            ?? r102 = 1;
            ?? r103 = r101;
            if (r101 == false) goto L5;
            r103 = 1;
        L5:
            int r104 = (r100 + r103) * 31;
            boolean r105 = this.f270641c;
            ?? r106 = r105;
            if (r105 == false) goto L8;
            r106 = 1;
        L8:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f270642d;
            if (r108 != null) goto L11;
            int r109 = 0;
        L12:
            int r110 = (r107 + r109) * 31;
            boolean r111 = this.f270643e;
            if (r111 == true) goto L17;
            r102 = r111;
        L17:
            return r110 + r102;
        L11:
            r109 = r108.hashCode();
            goto L12
        }

        public final String toString() {
            return "ExtraInfo(cert=" + this.f270639a + ", autoRequestPermission=" + this.f270640b + ", autoLeadSystemSetting=" + this.f270641c + ", customLeadSystemDialogContent=" + this.f270642d + ", execWithoutPermission=" + this.f270643e + ')';
        }

        public /* synthetic */ ExtraInfo(String r100, boolean r101, boolean r102, int r110) {
            if ((r110 & 2) == 0) goto L5;
            boolean r103 = true;
        L7:
            if ((r110 & 4) == 0) goto L9;
            boolean r104 = false;
        L10:
            this(r100, r103, r104, null, false);
            return;
        L9:
            r104 = r102;
            goto L10
        L5:
            r103 = r101;
            goto L7
        }

        public ExtraInfo(String r100, boolean r101, boolean r102, String r103, boolean r104) {
            Intrinsics.checkNotNullParameter(r100, TextureRenderKeys.KEY_IS_CERT);
            this.f270639a = r100;
            this.f270640b = r101;
            this.f270641c = r102;
            this.f270642d = r103;
            this.f270643e = r104;
            this.f270644f = TimonMedia$ExtraInfo$onPermissionRequest$1.INSTANCE;
            this.f270645g = TimonMedia$ExtraInfo$onPermissionResult$1.INSTANCE;
            this.f270646h = TimonMedia$ExtraInfo$onAlwaysDenied$1.INSTANCE;
            this.f270647i = true;
            this.f270649k = new LinkedHashMap();
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f270650a = null;

        static {
            int[] r100 = new int[TimonMediaType.values().length];
            r100[TimonMediaType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[TimonMediaType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[TimonMediaType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f270650a = r100;
        }
    }

    static {
        INSTANCE = new TimonMedia();
    }

    private TimonMedia() {
    }

    @JvmStatic
    public static final void pickMedia(Activity r100, ExtraInfo r101, xg7.a<Intent> r110) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "info");
        Intrinsics.checkNotNullParameter(r110, "callback");
        pickMedia$default(r100, null, false, r101, r110, 6, null);
    }

    @JvmStatic
    public static final void pickMedia(Activity r100, MediaPickType r101, ExtraInfo r110, xg7.a<Intent> r111) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r110, "info");
        Intrinsics.checkNotNullParameter(r111, "callback");
        pickMedia$default(r100, r101, false, r110, r111, 4, null);
    }

    @JvmStatic
    public static final void pickMedia(Activity r100, MediaPickType r101, String r110, xg7.a<Intent> r111) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r110, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r111, "callback");
        pickMedia$default(r100, r101, false, r110, r111, 4, null);
    }

    @JvmStatic
    public static final void pickMedia(Activity r100, String r101, xg7.a<Intent> r110) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r110, "callback");
        pickMedia$default(r100, null, false, r101, r110, 6, null);
    }

    @JvmStatic
    public static final void query(Activity r110, Uri r111, Bundle r112, ExtraInfo r113, xg7.a<Cursor> r114) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r112, "queryArgs");
        Intrinsics.checkNotNullParameter(r113, "info");
        Intrinsics.checkNotNullParameter(r114, "callback");
        query$default(r110, r111, null, r112, null, r113, r114, 20, null);
    }

    @JvmStatic
    public static final void query(Activity r110, Uri r111, Bundle r112, String r113, xg7.a<Cursor> r114) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r112, "queryArgs");
        Intrinsics.checkNotNullParameter(r113, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r114, "callback");
        query$default(r110, r111, null, r112, null, r113, r114, 20, null);
    }

    @JvmStatic
    public static final void query(Activity r110, Uri r111, ExtraInfo r112, xg7.a<Cursor> r113) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r112, "info");
        Intrinsics.checkNotNullParameter(r113, "callback");
        query$default(r110, r111, null, null, null, null, 0, 0, null, r112, r113, 508, null);
    }

    @JvmStatic
    public static final void query(Activity r110, Uri r111, String r112, xg7.a<Cursor> r113) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r112, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r113, "callback");
        query$default(r110, r111, null, null, null, null, 0, 0, null, r112, r113, 508, null);
    }

    @JvmStatic
    public static final void query(Activity r110, Uri r111, String[] r112, Bundle r113, ExtraInfo r114, xg7.a<Cursor> r115) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r113, "queryArgs");
        Intrinsics.checkNotNullParameter(r114, "info");
        Intrinsics.checkNotNullParameter(r115, "callback");
        query$default(r110, r111, r112, r113, null, r114, r115, 16, null);
    }

    @JvmStatic
    public static final void query(Activity r110, Uri r111, String[] r112, Bundle r113, String r114, xg7.a<Cursor> r115) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r113, "queryArgs");
        Intrinsics.checkNotNullParameter(r114, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r115, "callback");
        query$default(r110, r111, r112, r113, null, r114, r115, 16, null);
    }

    @JvmStatic
    public static final void query(Activity r110, Uri r111, String[] r112, ExtraInfo r113, xg7.a<Cursor> r114) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r113, "info");
        Intrinsics.checkNotNullParameter(r114, "callback");
        query$default(r110, r111, r112, null, null, null, 0, 0, null, r113, r114, 504, null);
    }

    @JvmStatic
    public static final void query(Activity r110, Uri r111, String[] r112, String r113, ExtraInfo r114, xg7.a<Cursor> r115) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r114, "info");
        Intrinsics.checkNotNullParameter(r115, "callback");
        query$default(r110, r111, r112, r113, null, null, 0, 0, null, r114, r115, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_TIMEOUT, null);
    }

    @JvmStatic
    public static final void query(Activity r110, Uri r111, String[] r112, String r113, String r114, xg7.a<Cursor> r115) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r114, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r115, "callback");
        query$default(r110, r111, r112, r113, null, null, 0, 0, null, r114, r115, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_TIMEOUT, null);
    }

    @JvmStatic
    public static final void query(Activity r110, Uri r111, String[] r112, String r113, xg7.a<Cursor> r114) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r113, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r114, "callback");
        query$default(r110, r111, r112, null, null, null, 0, 0, null, r113, r114, 504, null);
    }

    @JvmStatic
    public static final void query(Activity r110, Uri r111, String[] r112, String r113, String[] r114, ExtraInfo r115, xg7.a<Cursor> r210) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r115, "info");
        Intrinsics.checkNotNullParameter(r210, "callback");
        query$default(r110, r111, r112, r113, r114, null, 0, 0, null, r115, r210, 480, null);
    }

    @JvmStatic
    public static final void query(Activity r110, Uri r111, String[] r112, String r113, String[] r114, String r115, int r210, int r211, ExtraInfo r212, xg7.a<Cursor> r213) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r212, "info");
        Intrinsics.checkNotNullParameter(r213, "callback");
        query$default(r110, r111, r112, r113, r114, r115, r210, r211, null, r212, r213, 256, null);
    }

    @JvmStatic
    public static final void query(Activity r110, Uri r111, String[] r112, String r113, String[] r114, String r115, int r210, int r211, String r212, xg7.a<Cursor> r213) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r212, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r213, "callback");
        query$default(r110, r111, r112, r113, r114, r115, r210, r211, null, r212, r213, 256, null);
    }

    @JvmStatic
    public static final void query(Activity r110, Uri r111, String[] r112, String r113, String[] r114, String r115, int r210, ExtraInfo r211, xg7.a<Cursor> r212) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r211, "info");
        Intrinsics.checkNotNullParameter(r212, "callback");
        query$default(r110, r111, r112, r113, r114, r115, r210, 0, null, r211, r212, 384, null);
    }

    @JvmStatic
    public static final void query(Activity r110, Uri r111, String[] r112, String r113, String[] r114, String r115, int r210, String r211, xg7.a<Cursor> r212) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r211, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r212, "callback");
        query$default(r110, r111, r112, r113, r114, r115, r210, 0, null, r211, r212, 384, null);
    }

    @JvmStatic
    public static final void query(Activity r110, Uri r111, String[] r112, String r113, String[] r114, String r115, ExtraInfo r210, xg7.a<Cursor> r211) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r210, "info");
        Intrinsics.checkNotNullParameter(r211, "callback");
        query$default(r110, r111, r112, r113, r114, r115, 0, 0, null, r210, r211, BDVideoUploaderBase.KeyIsDynamicSliceLowSize, null);
    }

    @JvmStatic
    public static final void query(Activity r110, Uri r111, String[] r112, String r113, String[] r114, String r115, String r210, xg7.a<Cursor> r211) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r210, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r211, "callback");
        query$default(r110, r111, r112, r113, r114, r115, 0, 0, null, r210, r211, BDVideoUploaderBase.KeyIsDynamicSliceLowSize, null);
    }

    @JvmStatic
    public static final void query(Activity r110, Uri r111, String[] r112, String r113, String[] r114, String r115, xg7.a<Cursor> r210) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r115, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r210, "callback");
        query$default(r110, r111, r112, r113, r114, null, 0, 0, null, r115, r210, 480, null);
    }

    @JvmStatic
    public static final void queryMedia(Activity r110, ExtraInfo r111, xg7.a<List<BdMediaItem>> r112) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "info");
        Intrinsics.checkNotNullParameter(r112, "callback");
        queryMedia$default(r110, null, null, null, null, 0, 0, r111, r112, 126, null);
    }

    @JvmStatic
    public static final void queryMedia(Activity r110, MediaPickType r111, ExtraInfo r112, xg7.a<List<BdMediaItem>> r113) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r112, "info");
        Intrinsics.checkNotNullParameter(r113, "callback");
        queryMedia$default(r110, r111, null, null, null, 0, 0, r112, r113, 124, null);
    }

    @JvmStatic
    public static final void queryMedia(Activity r110, MediaPickType r111, String r112, ExtraInfo r113, xg7.a<List<BdMediaItem>> r114) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r113, "info");
        Intrinsics.checkNotNullParameter(r114, "callback");
        queryMedia$default(r110, r111, r112, null, null, 0, 0, r113, r114, 120, null);
    }

    @JvmStatic
    public static final void queryMedia(Activity r110, MediaPickType r111, String r112, String r113, xg7.a<List<BdMediaItem>> r114) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r113, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r114, "callback");
        queryMedia$default(r110, r111, r112, null, null, 0, 0, r113, r114, 120, null);
    }

    @JvmStatic
    public static final void queryMedia(Activity r110, MediaPickType r111, String r112, xg7.a<List<BdMediaItem>> r113) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r112, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r113, "callback");
        queryMedia$default(r110, r111, null, null, null, 0, 0, r112, r113, 124, null);
    }

    @JvmStatic
    public static final void queryMedia(Activity r110, MediaPickType r111, String r112, String[] r113, ExtraInfo r114, xg7.a<List<BdMediaItem>> r115) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r114, "info");
        Intrinsics.checkNotNullParameter(r115, "callback");
        queryMedia$default(r110, r111, r112, r113, null, 0, 0, r114, r115, 112, null);
    }

    @JvmStatic
    public static final void queryMedia(Activity r110, MediaPickType r111, String r112, String[] r113, String r114, int r115, ExtraInfo r116, xg7.a<List<BdMediaItem>> r117) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r116, "info");
        Intrinsics.checkNotNullParameter(r117, "callback");
        queryMedia$default(r110, r111, r112, r113, r114, r115, 0, r116, r117, 64, null);
    }

    @JvmStatic
    public static final void queryMedia(Activity r110, MediaPickType r111, String r112, String[] r113, String r114, int r115, String r116, xg7.a<List<BdMediaItem>> r117) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r116, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r117, "callback");
        queryMedia$default(r110, r111, r112, r113, r114, r115, 0, r116, r117, 64, null);
    }

    @JvmStatic
    public static final void queryMedia(Activity r110, MediaPickType r111, String r112, String[] r113, String r114, ExtraInfo r115, xg7.a<List<BdMediaItem>> r116) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r115, "info");
        Intrinsics.checkNotNullParameter(r116, "callback");
        queryMedia$default(r110, r111, r112, r113, r114, 0, 0, r115, r116, 96, null);
    }

    @JvmStatic
    public static final void queryMedia(Activity r110, MediaPickType r111, String r112, String[] r113, String r114, String r115, xg7.a<List<BdMediaItem>> r116) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r115, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r116, "callback");
        queryMedia$default(r110, r111, r112, r113, r114, 0, 0, r115, r116, 96, null);
    }

    @JvmStatic
    public static final void queryMedia(Activity r110, MediaPickType r111, String r112, String[] r113, String r114, xg7.a<List<BdMediaItem>> r115) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r114, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r115, "callback");
        queryMedia$default(r110, r111, r112, r113, null, 0, 0, r114, r115, 112, null);
    }

    @JvmStatic
    public static final void queryMedia(Activity r110, String r111, xg7.a<List<BdMediaItem>> r112) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r112, "callback");
        queryMedia$default(r110, null, null, null, null, 0, 0, r111, r112, 126, null);
    }

    @JvmStatic
    public static final void withReadPermission(Activity r100, ExtraInfo r101, MediaPickType r110, Function0<Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "info");
        Intrinsics.checkNotNullParameter(r110, "type");
        Intrinsics.checkNotNullParameter(r111, "block");
        withReadPermission$default(r100, r101, r110, null, r111, 8, null);
    }

    @JvmStatic
    public static final void withReadPermission(Activity r100, String r101, MediaPickType r110, Function0<Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r110, "type");
        Intrinsics.checkNotNullParameter(r111, "block");
        withReadPermission$default(r100, r101, r110, null, r111, 8, null);
    }

    @JvmStatic
    public static final void withWritePermission(Activity r100, ExtraInfo r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "info");
        Intrinsics.checkNotNullParameter(r102, "block");
        withWritePermission$default(r100, r101, null, r102, 4, null);
    }

    @JvmStatic
    public static final void withWritePermission(Activity r100, String r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r102, "block");
        withWritePermission$default(r100, r101, null, r102, 4, null);
    }

    public final boolean checkWriteMediaPermission$permission_keeper_storage_release(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        TimonMediaManager.f270660b.a(MapsKt.emptyMap());
        if (ContextCompat.checkSelfPermission(r100, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final MediaPermissionResult checkReadMediaPermission(Context r100, TimonMediaType r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "type");
        TimonMediaManager.f270660b.a(MapsKt.emptyMap());
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 33) goto L25;
        int r103 = a.f270650a[r101.ordinal()];
        boolean r104 = true;
        if (r103 == 1) goto L19;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L14;
        if (ContextCompat.checkSelfPermission(r100, BaseConstants.PERMISSION_READ_MEDIA_AUDIO) == 0) goto L22;
    L21:
        r104 = false;
    L22:
        if (r104 == false) goto L25;
        return MediaPermissionResult.FULL;
    L14:
        throw new NoWhenBranchMatchedException();
    L16:
        if (ContextCompat.checkSelfPermission(r100, BaseConstants.PERMISSION_READ_MEDIA_VIDEO) != 0) goto L21;
    L19:
        if (ContextCompat.checkSelfPermission(r100, BaseConstants.PERMISSION_READ_MEDIA_IMAGES) != 0) goto L21;
    L25:
        if (r102 < 34) goto L30;
        if (ContextCompat.checkSelfPermission(r100, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") != 0) goto L30;
        return MediaPermissionResult.USER_SELECT;
    L30:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.READ_EXTERNAL_STORAGE") != 0) goto L33;
        return MediaPermissionResult.FULL;
    L33:
        return MediaPermissionResult.NONE;
    }

    @JvmStatic
    public static final String convertUriToPath(Activity r100, Uri r101, ExtraInfo r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, "info");
        TimonMediaInternal.b r103 = TimonMediaInternal.f270655a;
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, "info");
        r102.f270648j = 310012;
        int r104 = b.f270669a;
        if (b.e(r100) == false) goto L5;
    L7:
        String r105 = BdFileUtils.convertUriToPath(r100, r101);
        if (r105 != null) goto L10;
        r102.f270649k.put("success", "1");
    L11:
        TimonMediaManager.f270660b.a(r102.f270649k);
        return r105;
    L10:
        r102.f270649k.put("success", "2");
        goto L11
    L5:
        if (b.d(r100, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}) == true) goto L7;
        r102.f270649k.put("success", "0");
        return null;
    }

    @JvmStatic
    public static final void takeAudio(Activity r100, String r101, xg7.a<Intent> r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r102, "callback");
        takeAudio$permission_keeper_storage_release(r100, new ExtraInfo(r101, false, false, null, true), r102);
    }

    @JvmStatic
    public static final void takeAudio$permission_keeper_storage_release(Activity r100, ExtraInfo r101, xg7.a<Intent> r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "info");
        Intrinsics.checkNotNullParameter(r102, "callback");
        TimonMediaInternal.g(r100, r101, r102);
    }

    @JvmStatic
    public static final void takePhoto(Activity r100, String r101, xg7.a<Intent> r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r102, "callback");
        boolean r103 = false;
        takePhoto(r100, new ExtraInfo(r101, r103, r103, 30), r102);
    }

    @JvmStatic
    public static final void takeVideo(Activity r100, String r101, xg7.a<Intent> r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r102, "callback");
        boolean r103 = false;
        takeVideo(r100, new ExtraInfo(r101, r103, r103, 30), r102);
    }

    @JvmStatic
    public static final String convertUriToPath(Activity r100, Uri r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, TextureRenderKeys.KEY_IS_CERT);
        boolean r103 = false;
        return convertUriToPath(r100, r101, new ExtraInfo(r102, r103, r103, 30));
    }

    @JvmStatic
    public static final void takePhoto(Activity r100, ExtraInfo r101, xg7.a<Intent> r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "info");
        Intrinsics.checkNotNullParameter(r102, "callback");
        TimonMediaInternal.h(r100, null, r101, r102);
    }

    @JvmStatic
    public static final void takeVideo(Activity r100, ExtraInfo r101, xg7.a<Intent> r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "info");
        Intrinsics.checkNotNullParameter(r102, "callback");
        TimonMediaInternal.i(r100, null, r101, r102);
    }

    @JvmStatic
    public static final void getLatestPictures(Activity r110, int r111, ExtraInfo r112, xg7.a<List<Uri>> r113) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r112, "info");
        Intrinsics.checkNotNullParameter(r113, "callback");
        if (r111 > 0) goto L5;
        r113.a(ResultCode.ArgumentError.getValue(), null, null);
    L5:
        TimonMediaInternal.b r100 = TimonMediaInternal.f270655a;
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r112, "info");
        Intrinsics.checkNotNullParameter(r113, "callback");
        r112.f270648j = 310010;
        r112.f270649k.put("query_count", String.valueOf(r111));
        TimonMediaInternal.a r101 = new TimonMediaInternal.a(r113, r112);
        Uri r102 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] r103 = {DBDefinition.ID, "date_added"};
        String r114 = r112.f270639a;
        boolean r115 = r112.f270640b;
        boolean r116 = r112.f270641c;
        String r117 = r112.f270642d;
        boolean r118 = r112.f270643e;
        Intrinsics.checkNotNullParameter(r114, TextureRenderKeys.KEY_IS_CERT);
        TimonMediaInternal.e(r110, r102, r103, null, null, "date_added DESC", r111, 0, null, new ExtraInfo(r114, r115, r116, r117, r118), new com.bytedance.timon.permission.storage.manager.a(r111, r112, r101));
    }

    @JvmStatic
    public static final void insertAlbum(Activity r100, ah7.a r101, String r102, xg7.a<Uri> r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r102, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r103, "callback");
        boolean r104 = false;
        insertAlbum(r100, r101, new ExtraInfo(r102, r104, r104, 30), r103);
    }

    @JvmStatic
    public static final void takePhoto(Activity r100, Intent r101, String r102, xg7.a<Intent> r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "intent");
        Intrinsics.checkNotNullParameter(r102, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r103, "callback");
        boolean r104 = false;
        takePhoto(r100, r101, new ExtraInfo(r102, r104, r104, 30), r103);
    }

    @JvmStatic
    public static final void takeVideo(Activity r100, Intent r101, String r102, xg7.a<Intent> r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "intent");
        Intrinsics.checkNotNullParameter(r102, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r103, "callback");
        boolean r104 = false;
        takeVideo(r100, r101, new ExtraInfo(r102, r104, r104, 30), r103);
    }

    @JvmStatic
    public static final void withWritePermission(Activity r100, ExtraInfo r101, xg7.a<Unit> r102, final Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "info");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r103, "block");
        r101.f270648j = 310013;
        final TimonMediaInternal.a r104 = new TimonMediaInternal.a(r102, r101);
        int r105 = b.f270669a;
        if (b.e(r100) == false) goto L5;
        r103.invoke();
        r104.a(ResultCode.RESULT_OK.getValue(), null, null);
        return;
    L5:
        b.b(r100, r101, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, r104, new C106571(r103, r104));
    }

    @JvmStatic
    public static final void getLatestPictures(Activity r100, int r101, String r102, xg7.a<List<Uri>> r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r102, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r103, "callback");
        boolean r104 = false;
        getLatestPictures(r100, r101, new ExtraInfo(r102, r104, r104, 30), r103);
    }

    @JvmStatic
    public static final void insertAlbum(Activity r100, ah7.a r101, ExtraInfo r102, xg7.a<Uri> r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r102, "info");
        Intrinsics.checkNotNullParameter(r103, "callback");
        TimonMediaInternal.b(r100, r102, r103);
    }

    @JvmStatic
    public static final void takePhoto(Activity r100, Intent r101, ExtraInfo r102, xg7.a<Intent> r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "intent");
        Intrinsics.checkNotNullParameter(r102, "info");
        Intrinsics.checkNotNullParameter(r103, "callback");
        TimonMediaInternal.h(r100, r101, r102, r103);
    }

    @JvmStatic
    public static final void takeVideo(Activity r100, Intent r101, ExtraInfo r102, xg7.a<Intent> r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "intent");
        Intrinsics.checkNotNullParameter(r102, "info");
        Intrinsics.checkNotNullParameter(r103, "callback");
        TimonMediaInternal.i(r100, r101, r102, r103);
    }

    @JvmStatic
    public static final void withWritePermission(Activity r100, String r101, xg7.a<Unit> r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r103, "block");
        boolean r104 = false;
        withWritePermission(r100, new ExtraInfo(r101, r104, r104, 30), r102, r103);
    }

    @JvmStatic
    public static final void pickMedia(Activity r100, MediaPickType r101, boolean r102, String r103, xg7.a<Intent> r104) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r103, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r104, "callback");
        boolean r105 = false;
        pickMedia(r100, r101, r102, new ExtraInfo(r103, r105, r105, 30), r104);
    }

    @JvmStatic
    public static final void withReadPermission(Activity r100, ExtraInfo r101, MediaPickType r102, xg7.a<Unit> r103, final Function0<Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "info");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r103, "callback");
        Intrinsics.checkNotNullParameter(r104, "block");
        r101.f270648j = 310014;
        final TimonMediaInternal.a r105 = new TimonMediaInternal.a(r103, r101);
        int r106 = b.f270669a;
        b.b(r100, r101, b.c(r100, r102), r105, new AnonymousClass1(r104, r105));
    }

    @JvmStatic
    public static final void pickMedia(Activity r100, MediaPickType r101, boolean r102, ExtraInfo r103, xg7.a<Intent> r104) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r103, "info");
        Intrinsics.checkNotNullParameter(r104, "callback");
        TimonMediaInternal.c(r100, r101, r102, r103, r104);
    }

    @JvmStatic
    public static final void withReadPermission(Activity r100, String r101, MediaPickType r102, xg7.a<Unit> r103, Function0<Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r103, "callback");
        Intrinsics.checkNotNullParameter(r104, "block");
        boolean r105 = false;
        withReadPermission(r100, new ExtraInfo(r101, r105, r105, 30), r102, r103, r104);
    }

    @JvmStatic
    public static final void getNewFiles(Activity r100, File r101, int r110, boolean r111, String r112, xg7.a<List<File>> r113) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r112, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r113, "callback");
        if (r110 > 0) goto L5;
        r113.a(ResultCode.ArgumentError.getValue(), null, null);
    L5:
        boolean r102 = false;
        getNewFiles(r100, r101, r110, r111, new ExtraInfo(r112, r102, r102, 30), r113);
    }

    public static /* synthetic */ void withWritePermission$default(Activity r100, ExtraInfo r101, xg7.a r102, Function0 r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r102 = TimonMediaInternal.f270655a;
    L5:
        withWritePermission(r100, r101, r102, r103);
    }

    @JvmStatic
    public static final void getNewFiles(Activity r100, File r101, int r102, boolean r103, ExtraInfo r104, xg7.a<List<File>> r105) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r104, "info");
        Intrinsics.checkNotNullParameter(r105, "callback");
        if (r102 > 0) goto L5;
        r105.a(ResultCode.ArgumentError.getValue(), null, null);
    L5:
        TimonMediaInternal.a(r100, r101, r102, r103, r104, r105);
    }

    public static /* synthetic */ void withWritePermission$default(Activity r100, String r101, xg7.a r102, Function0 r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r102 = TimonMediaInternal.f270655a;
    L5:
        withWritePermission(r100, r101, r102, r103);
    }

    public static /* synthetic */ void pickMedia$default(Activity r100, MediaPickType r101, boolean r102, ExtraInfo r103, xg7.a r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r101 = MediaPickType.TYPE_IMAGE;
    L6:
        if ((r105 & 4) == 0) goto L8;
        r102 = false;
    L8:
        pickMedia(r100, r101, r102, r103, r104);
    }

    @JvmStatic
    public static final void query(Activity r100, Uri r101, String[] r110, Bundle r111, CancellationSignal r112, String r113, xg7.a<Cursor> r114) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r111, "queryArgs");
        Intrinsics.checkNotNullParameter(r113, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r114, "callback");
        boolean r102 = false;
        query(r100, r101, r110, r111, r112, new ExtraInfo(r113, r102, r102, 30), r114);
    }

    public static /* synthetic */ void withReadPermission$default(Activity r100, ExtraInfo r101, MediaPickType r102, xg7.a r103, Function0 r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r103 = TimonMediaInternal.f270655a;
    L5:
        withReadPermission(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ void pickMedia$default(Activity r100, MediaPickType r101, boolean r102, String r103, xg7.a r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r101 = MediaPickType.TYPE_IMAGE;
    L6:
        if ((r105 & 4) == 0) goto L8;
        r102 = false;
    L8:
        pickMedia(r100, r101, r102, r103, r104);
    }

    @JvmStatic
    public static final void query(Activity r100, Uri r101, String[] r102, Bundle r103, CancellationSignal r104, ExtraInfo r105, xg7.a<Cursor> r106) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r103, "queryArgs");
        Intrinsics.checkNotNullParameter(r105, "info");
        Intrinsics.checkNotNullParameter(r106, "callback");
        TimonMediaInternal.d(r100, r101, r102, r103, r104, r105, r106);
    }

    public static /* synthetic */ void withReadPermission$default(Activity r100, String r101, MediaPickType r102, xg7.a r103, Function0 r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r103 = TimonMediaInternal.f270655a;
    L5:
        withReadPermission(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ void query$default(Activity r100, Uri r110, String[] r111, Bundle r112, CancellationSignal r113, ExtraInfo r114, xg7.a r115, int r116, Object r117) {
        if ((r116 & 4) == 0) goto L5;
        String[] r101 = null;
    L7:
        if ((r116 & 16) == 0) goto L9;
        CancellationSignal r102 = null;
    L10:
        query(r100, r110, r101, r112, r102, r114, r115);
        return;
    L9:
        r102 = r113;
        goto L10
    L5:
        r101 = r111;
        goto L7
    }

    @JvmStatic
    public static final void queryMedia(Activity r110, MediaPickType r111, String r112, String[] r113, String r114, int r115, int r116, String r117, xg7.a<List<BdMediaItem>> r118) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r117, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r118, "callback");
        boolean r100 = false;
        queryMedia(r110, r111, r112, r113, r114, r115, r116, new ExtraInfo(r117, r100, r100, 30), r118);
    }

    public static /* synthetic */ void query$default(Activity r100, Uri r110, String[] r111, Bundle r112, CancellationSignal r113, String r114, xg7.a r115, int r116, Object r117) {
        if ((r116 & 4) == 0) goto L5;
        String[] r101 = null;
    L7:
        if ((r116 & 16) == 0) goto L9;
        CancellationSignal r102 = null;
    L10:
        query(r100, r110, r101, r112, r102, r114, r115);
        return;
    L9:
        r102 = r113;
        goto L10
    L5:
        r101 = r111;
        goto L7
    }

    @JvmStatic
    public static final void queryMedia(Activity r100, MediaPickType r101, String r102, String[] r103, String r104, int r105, int r106, ExtraInfo r107, xg7.a<List<BdMediaItem>> r108) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r107, "info");
        Intrinsics.checkNotNullParameter(r108, "callback");
        TimonMediaInternal.f(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    }

    @JvmStatic
    public static final void query(Activity r110, Uri r111, String[] r112, String r113, String[] r114, String r115, int r116, int r210, CancellationSignal r211, String r212, xg7.a<Cursor> r213) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r212, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r213, "callback");
        boolean r100 = false;
        query(r110, r111, r112, r113, r114, r115, r116, r210, r211, new ExtraInfo(r212, r100, r100, 30), r213);
    }

    public static /* synthetic */ void queryMedia$default(Activity r110, MediaPickType r111, String r112, String[] r113, String r114, int r115, int r116, ExtraInfo r117, xg7.a r118, int r119, Object r210) {
        if ((r119 & 2) == 0) goto L5;
        MediaPickType r100 = MediaPickType.TYPE_IMAGE;
    L7:
        if ((r119 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r119 & 8) == 0) goto L13;
        String[] r102 = null;
    L15:
        if ((r119 & 16) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r119 & 32) == 0) goto L21;
        int r104 = -1;
    L23:
        if ((r119 & 64) == 0) goto L25;
        int r105 = -1;
    L26:
        queryMedia(r110, r100, r101, r102, r103, r104, r105, r117, r118);
        return;
    L25:
        r105 = r116;
        goto L26
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @JvmStatic
    public static final void query(Activity r100, Uri r101, String[] r102, String r103, String[] r104, String r105, int r106, int r107, CancellationSignal r108, ExtraInfo r110, xg7.a<Cursor> r111) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r110, "info");
        Intrinsics.checkNotNullParameter(r111, "callback");
        TimonMediaInternal.e(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111);
    }

    public static /* synthetic */ void queryMedia$default(Activity r110, MediaPickType r111, String r112, String[] r113, String r114, int r115, int r116, String r117, xg7.a r118, int r119, Object r210) {
        if ((r119 & 2) == 0) goto L5;
        MediaPickType r100 = MediaPickType.TYPE_IMAGE;
    L7:
        if ((r119 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r119 & 8) == 0) goto L13;
        String[] r102 = null;
    L15:
        if ((r119 & 16) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r119 & 32) == 0) goto L21;
        int r104 = -1;
    L23:
        if ((r119 & 64) == 0) goto L25;
        int r105 = -1;
    L26:
        queryMedia(r110, r100, r101, r102, r103, r104, r105, r117, r118);
        return;
    L25:
        r105 = r116;
        goto L26
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public static /* synthetic */ void query$default(Activity r110, Uri r111, String[] r112, String r113, String[] r114, String r115, int r210, int r211, CancellationSignal r212, ExtraInfo r213, xg7.a r214, int r215, Object r216) {
        if ((r215 & 4) == 0) goto L5;
        String[] r100 = null;
    L7:
        if ((r215 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r215 & 16) == 0) goto L13;
        String[] r102 = null;
    L15:
        if ((r215 & 32) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r215 & 64) == 0) goto L21;
        int r104 = -1;
    L23:
        if ((r215 & 128) == 0) goto L25;
        int r116 = 0;
    L27:
        if ((r215 & 256) == 0) goto L29;
        CancellationSignal r117 = null;
    L30:
        query(r110, r111, r100, r101, r102, r103, r104, r116, r117, r213, r214);
        return;
    L29:
        r117 = r212;
        goto L30
    L25:
        r116 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }

    public static /* synthetic */ void query$default(Activity r110, Uri r111, String[] r112, String r113, String[] r114, String r115, int r210, int r211, CancellationSignal r212, String r213, xg7.a r214, int r215, Object r216) {
        if ((r215 & 4) == 0) goto L5;
        String[] r100 = null;
    L7:
        if ((r215 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r215 & 16) == 0) goto L13;
        String[] r102 = null;
    L15:
        if ((r215 & 32) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r215 & 64) == 0) goto L21;
        int r104 = -1;
    L23:
        if ((r215 & 128) == 0) goto L25;
        int r116 = 0;
    L27:
        if ((r215 & 256) == 0) goto L29;
        CancellationSignal r117 = null;
    L30:
        query(r110, r111, r100, r101, r102, r103, r104, r116, r117, r213, r214);
        return;
    L29:
        r117 = r212;
        goto L30
    L25:
        r116 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
