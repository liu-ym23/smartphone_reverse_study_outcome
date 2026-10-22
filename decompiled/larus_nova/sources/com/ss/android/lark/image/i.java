package com.ss.android.lark.image;

import android.app.Application;
import com.bumptech.glide.util.GlideLogUtil;
import com.bytedance.i18n.claymore.PluginServiceLoader;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.image.entity.AlbumSerialImage;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.PassThroughImage;
import com.ss.android.lark.image.entity.ReactionImage;
import com.ss.android.lark.image.entity.VideoImage;
import com.ss.android.lark.image.impl.album.AlbumSerialImageLoader;
import com.ss.android.lark.image.impl.avatar.AvatarImageLoader;
import com.ss.android.lark.image.impl.encrtypt.EncryptImageLoader;
import com.ss.android.lark.image.impl.passthrough.PassThroughImageLoader;
import com.ss.android.lark.image.impl.reaction.ReactionImageLoader;
import com.ss.android.lark.image.impl.video.VideoImageLoader;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.MemoryCallbackManager;
import com.ss.android.lark.utils.LarkContext;
import java.io.InputStream;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f426365a;

    public class a implements MemoryCallbackManager.MemoryCallback {
        public a() {
        }

        @Override // com.ss.android.lark.monitor.callback.MemoryCallbackManager.MemoryCallback
        public final void onTrimMemory(int r100, int r101, int r102, int r103) {
        }

        @Override // com.ss.android.lark.monitor.callback.MemoryCallbackManager.MemoryCallback
        public final void onJavaMemoryReachTop() {
            final Application r100 = LarkContext.getApplication();
            com.ss.android.lark.image.a r101 = ImageModule.f426214a;
            UICallbackExecutor.execute(new b(r100));
        }
    }

    public static void a() {
        Log.i("ImageModuleProvider", "initIfNeed, hasInit:" + f426365a);
        if (f426365a == false) goto L5;
        return;
    L5:
        f426365a = true;
        Application r100 = LarkContext.getApplication();
        com.ss.android.lark.image.a r101 = ImageModule.f426214a;
        ImageLoader.registerLoadModelHook(r100, AvatarImage.class, InputStream.class, new AvatarImageLoader.Factory());
        ImageLoader.registerLoadModelHook(r100, ReactionImage.class, InputStream.class, new ReactionImageLoader.Factory());
        ImageLoader.registerLoadModelHook(r100, EncryptImage.class, InputStream.class, new EncryptImageLoader.Factory());
        ImageLoader.registerLoadModelHook(r100, VideoImage.class, InputStream.class, new VideoImageLoader.Factory());
        ImageLoader.registerLoadModelHook(r100, AlbumSerialImage.class, InputStream.class, new AlbumSerialImageLoader.Factory());
        ImageLoader.registerLoadModelHook(r100, PassThroughImage.class, InputStream.class, new PassThroughImageLoader.Factory());
        Iterator r102 = PluginServiceLoader.loadAll(vkb.a.class);
    L7:
        if (r102.hasNext() == false) goto L9;
        vkb.a r103 = (vkb.a) r102.next();
        Log.i("ImageModule", "ImageModule registerExtraLoadModelHook <" + r103.getModelClass() + ">, " + r103.a());
        ImageLoader.registerLoadModelHook(r100, r103.getModelClass(), r103.getResourceClass(), r103.a());
        goto L7
    L9:
        boolean r104 = idb.f.a().isEnable("lark.feature.write.glide.log.to.file");
        Log.i("ImageModule", "initImageLoaderLog, isEnable:" + r104);
        GlideLogUtil.enableGlideWriter(r104);
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == false) goto L12;
        GlideLogUtil.incrementErrorCount();
    L12:
        clb.a r105 = ykb.b.f568292a;
        f r106 = new f();
        Intrinsics.checkNotNullParameter(r106, "dependency");
        ykb.b.f568292a = r106;
        MemoryCallbackManager.getInstance().registerMemoryCallback(new a());
    }
}
