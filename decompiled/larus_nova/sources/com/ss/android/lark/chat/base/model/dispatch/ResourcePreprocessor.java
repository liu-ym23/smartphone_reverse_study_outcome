package com.ss.android.lark.chat.base.model.dispatch;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.media.v1.PreprocessResourceRequest;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.LarkUriUtil;
import com.ss.android.lark.abtest.api.IABTestService;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.c1;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.videosend.compress.VideoCompressResult;
import com.ss.android.lark.videosend.compress.VideoPreCompressManager;
import com.ss.android.lark.videosend.tools.CompressPathManager;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes35.dex */
public final class ResourcePreprocessor implements qzb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final okb.b f411726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f411727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, d> f411728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f411729d;

    public static final enum FileType extends Enum<FileType> {
        public static final FileType FILE = null;
        public static final FileType IMAGE = null;
        public static final FileType MEDIA = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FileType[] f411730a = null;
        public int index;

        static {
            FileType r100 = new FileType("FILE", 0, 1);
            FILE = r100;
            FileType r101 = new FileType("IMAGE", 1, 2);
            IMAGE = r101;
            FileType r102 = new FileType("MEDIA", 2, 5);
            MEDIA = r102;
            f411730a = new FileType[]{r100, r101, r102};
        }

        public static FileType[] values() {
            return (FileType[]) f411730a.clone();
        }

        public static FileType fromValue(int r100) {
            FileType[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            FileType r104 = r101[r103];
            if (r104.index == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            return FILE;
        }

        public static FileType valueOf(String r100) {
            return (FileType) r27.a.a(FileType.class, r100);
        }

        public FileType(String r100, int r101, int r102) {
            super(r100, r101);
            this.index = r102;
        }
    }

    public class ImagePreprocessor extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ResourcePreprocessor f411731a;

        public ImagePreprocessor(ResourcePreprocessor r100) {
            this.f411731a = r100;
        }

        @Override // com.ss.android.lark.chat.base.model.dispatch.ResourcePreprocessor.e
        public final boolean a(d r100) {
            return !TextUtils.isEmpty(r100.f411735b);
        }

        @Override // com.ss.android.lark.chat.base.model.dispatch.ResourcePreprocessor.e
        public final void b(final d r100, final IGetDataCallback<String> r110) {
            boolean r101 = true;
            File r102 = com.ss.android.lark.vfs.d.a().G(r100.f411735b, true);     // Catch: IOException -> L5
        L8:
            if (r102 != null) goto L10;
        L22:
            Log.e("ResourcePreprocessor", "preprocess failed, file not exist path = " + r100.f411735b);
            return;
        L10:
            if (r102.exists() == false) goto L22;
            final IGetDataCallback<String> r103 = new AnonymousClass1(this, r100, r110);
            if (r100.f411741h == true) goto L20;
            final String r104 = r102.getName();
            Log.i("ResourcePreprocessor", "preprocessImage - compress start: " + r104);
            int r111 = blb.c.f19525a;
            Context r112 = ImSdk.f425890a.getContext();
            String r105 = r102.getPath();
            ResourcePreprocessor r106 = this.f411731a;
            r106.getClass();
            boolean r107 = ((Boolean) ((IABTestService) ApiUtils.getApi(IABTestService.class)).getAbTestValue(gua.a.class, true)).booleanValue();
            Log.i("ResourcePreprocessor", "isEnableConvertWebp:" + r106.f411727b + ", isExperimentEnable:" + r107);
            if (r106.f411727b == false) goto L18;
            if (r107 == false) goto L18;
        L19:
            blb.c.d(r112, r105, r101, new AnonymousClass2(this, r104, r103));
            return;
        L18:
            r101 = false;
            goto L19
        L20:
            r103.onSuccess(r102.getPath());
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            r102 = null;
            goto L8
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f411732a = null;

        static {
            int[] r100 = new int[FileType.values().length];
            f411732a = r100;
            r100[FileType.FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f411732a[FileType.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f411732a[FileType.MEDIA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class b extends e {
        public b() {
        }

        @Override // com.ss.android.lark.chat.base.model.dispatch.ResourcePreprocessor.e
        public final boolean a(d r100) {
            if (TextUtils.isEmpty(r100.f411735b) == true) goto L5;
        L8:
            return true;
        L5:
            if (r100.f411736c != null) goto L8;
            return false;
        }

        @Override // com.ss.android.lark.chat.base.model.dispatch.ResourcePreprocessor.e
        public final void b(d r100, IGetDataCallback<String> r101) {
            if (TextUtils.isEmpty(r100.f411735b) == false) goto L5;
            String r102 = LarkUriUtil.e(LarkContext.getApplication(), r100.f411736c);
        L7:
            if (TextUtils.isEmpty(r102) == false) goto L10;
            Log.w("ResourcePreprocessor", "preprocess file path is empty");
            Exception r103 = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
            ErrorResult r104 = new ErrorResult(0);
            ErrorResult.access$002(r104, -1);
            ErrorResult.access$102(r104, -9999);
            ErrorResult.access$202(r104, 0);
            ErrorResult.access$302(r104, r103);
            ErrorResult.access$402(r104, "");
            ErrorResult.access$502(r104, "Get file path failed");
            ErrorResult.access$602(r104, "");
            ErrorResult.access$702(r104, "");
            ErrorResult.access$802(r104, 0);
            ErrorResult.access$902(r104, null);
            ErrorResult.access$1002(r104, null);
            ErrorResult.access$1102(r104, null);
            r101.onError(r104);
            return;
        L10:
            String r105 = ResourcePreprocessor.c(PreprocessResourceRequest.FileType.FILE, r102, Long.valueOf(c1.b(ImSdk.f425890a.getContext(), r100.f411736c)));
            Log.d("ResourcePreprocessor", "preprocess file onSuccess:" + r105);
            if (TextUtils.isEmpty(r105) == true) goto L13;
            r100.f411737d = r105;
        L13:
            r101.onSuccess(r105);
            return;
        L5:
            r102 = r100.f411735b;
            goto L7
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ResourcePreprocessor f411733a = null;

        static {
            f411733a = new ResourcePreprocessor();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FileType f411734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f411735b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Uri f411736c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f411737d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f411738e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f411739f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f411740g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f411741h;

        public final int hashCode() {
            return Objects.hash(new Object[]{this.f411734a, this.f411735b, Boolean.valueOf(this.f411740g), Boolean.valueOf(this.f411741h)});
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f411740g == r101.f411740g) goto L11;
        L17:
            return false;
        L11:
            if (this.f411741h != r101.f411741h) goto L17;
            if (this.f411734a != r101.f411734a) goto L17;
            if (Objects.equals(this.f411735b, r101.f411735b) == false) goto L17;
            return true;
        }

        public d(FileType r100, String r101, Uri r102, boolean r103, boolean r104) {
            this.f411734a = r100;
            this.f411735b = r101;
            this.f411736c = r102;
            this.f411740g = r103;
            this.f411741h = r104;
        }
    }

    public static abstract class e {
        public e() {
        }

        public abstract boolean a(d r100);

        public abstract void b(d r100, IGetDataCallback<String> r101);
    }

    public static class f extends e {

        public class a extends oac.b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f411742b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f411743c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ IGetDataCallback f411744d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ f f411745e;

            @Override // oac.b, com.ss.android.lark.videosend.compress.b
            public final void c(VideoCompressResult r100) {
                super.c(r100);
                ExecutorService r101 = CoreThreadPool.getDefault().getCachedThreadPool();
                final d r102 = this.f411742b;
                final String r103 = this.f411743c;
                final IGetDataCallback r104 = this.f411744d;
                r101.execute(new m(this, r102, r103, r104));
            }

            public a(f r100, String r101, d r102, String r103, IGetDataCallback r104) {
                this.f411745e = r100;
                this.f411742b = r102;
                this.f411743c = r103;
                this.f411744d = r104;
                super(r101, null);
            }
        }

        public f() {
        }

        @Override // com.ss.android.lark.chat.base.model.dispatch.ResourcePreprocessor.e
        public final boolean a(d r100) {
            return !TextUtils.isEmpty(r100.f411735b);
        }

        @Override // com.ss.android.lark.chat.base.model.dispatch.ResourcePreprocessor.e
        public final void b(d r110, IGetDataCallback<String> r111) {
            String r100 = r110.f411735b;
            if (new PolarisFileWrapper(r100).exists() == true) goto L5;
            return;
        L5:
            String r101 = CompressPathManager.generateCompressFilePath(r100, Boolean.valueOf(r110.f411741h));
            String r102 = com.ss.android.lark.sdk.a.a();
            if (TextUtils.isEmpty(r101) == false) goto L8;
            return;
        L8:
            if (TextUtils.isEmpty(r102) == true) goto L17;
            r110.f411739f = r102;
            if (VFSFiles.f444819b.i(r101).canRead() == false) goto L13;
            c(r110, r101, r111);
            return;
        L13:
            VideoPreCompressManager.compress(new VideoPreCompressManager.a(VideoPreCompressManager.Scene.SELECT_VIDEO, r100, r110.f411741h, new a(this, r100, r110, r101, r111)));
            return;
        }

        public static void c(d r100, String r101, IGetDataCallback r102) {
            String r103 = ResourcePreprocessor.c(PreprocessResourceRequest.FileType.MEDIA, r101, null);
            if (TextUtils.isEmpty(r103) == true) goto L6;
            r100.f411737d = r103;
        L6:
            if (TextUtils.isEmpty(r101) == true) goto L8;
            r100.f411738e = r101;
        L8:
            if (r102 == null) goto L11;
            r102.onSuccess(r103);
            return;
        }
    }

    public ResourcePreprocessor() {
        okb.b r100 = ImSdkProxy.c();
        this.f411726a = r100;
        this.f411727b = r100.isFeatureGatingEnable("lark.android.img.convert.to.webp");
        this.f411728c = Collections.synchronizedMap(new HashMap());
        if (this.f411729d != null) goto L5;
        this.f411729d = CoreThreadPool.newThreadHandler("ResourcePreprocessor", new k(this));
    L5:
        ImSdkProxy.e().registerUserSwitchListener(this);
    }

    public static String a(d r100) {
        FileType r101 = r100.f411734a;
        if (r101 != FileType.MEDIA) goto L6;
        return r100.f411738e;
    L6:
        if (r101 != FileType.IMAGE) goto L9;
        return r100.f411735b + "_" + r100.f411741h;
    L9:
        if (r101 != FileType.FILE) goto L15;
        Uri r102 = r100.f411736c;
        if (r102 == null) goto L13;
        String r103 = r102.getPath();
    L14:
        Log.d("ResourcePreprocessor", "file getKeyPath:" + r103);
        return r103;
    L13:
        r103 = r100.f411735b;
        goto L14
    L15:
        return null;
    }

    public final void d(d r100) {
        FileType r101 = r100.f411734a;
        if (r101 != FileType.MEDIA) goto L6;
    L10:
        boolean r102 = true;
    L13:
        if (r102 == true) goto L16;
        Log.i("ResourcePreprocessor", "preprocessResource not enabled，file type is " + r100.f411734a);
        return;
    L16:
        Log.i("ResourcePreprocessor", "delayPreprocessResource:" + r100.f411735b + "/ preprocessKey:" + r100.f411737d + "/ checked:" + r100.f411740g + "/isOrigin:" + r100.f411741h + "/fileType:" + r100.f411734a + HTTP.URL_DEFAULT + this.f411728c.get(a(r100)));
        if (r100.f411740g == false) goto L19;
        Handler r103 = this.f411729d;
        r103.sendMessage(r103.obtainMessage(0, r100));
        return;
    L19:
        d r104 = b(a(r100), false);
        this.f411729d.removeMessages(0, r104);
        if (r104 != null) goto L22;
        return;
    L22:
        if (TextUtils.isEmpty(r104.f411737d) == true) goto L27;
        Handler r105 = this.f411729d;
        r105.sendMessage(r105.obtainMessage(1, r100));
        return;
    L27:
        return;
    L6:
        if (r101 == FileType.FILE) goto L10;
        if (r101 == FileType.IMAGE) goto L10;
        r102 = false;
        goto L13
    }

    public final d b(String r100, boolean r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        if (r101 == false) goto L10;
        return this.f411728c.remove(r100);
    L10:
        return this.f411728c.get(r100);
    }

    public static String c(PreprocessResourceRequest.FileType r100, String r101, Long r102) {
        String r103 = (String) SdkSender.syncSend(Command.PREPROCESS_RESOURCE, new PreprocessResourceRequest.Builder().file_type(r100).file_path(r101).file_handle(r102), new l());
        Log.i("ResourcePreprocessor", "notifySdkPreprocessResource:" + r103);
        return r103;
    }
}
