package d76;

import android.content.Context;
import android.os.Build;
import android.view.Surface;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.base.LLog;
import com.ss.android.ugc.aweme.live.alphaplayer.model.VideoInfo;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.player.MediaPlayerClient;
import com.ss.ttm.player.OSPlayerClient;
import com.ss.ttm.player.TTPlayerConfiger;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends AbsPlayer<b> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f467249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public x f467250h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d76.c f467251i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f467252j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C5642b f467253k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f467254l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f467255m;

    public class a implements MediaPlayer.OnPreparedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f467256a;

        public a(b r100) {
            this.f467256a = r100;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.ss.ttm.player.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer r100) {
            if (this.f467256a.f451186d == null) goto L6;
            LLog.i("x-alpha-video", "Prepare success with player : [" + this.f467256a.f467250h + "]");
            b r101 = this.f467256a;
            r101.f451186d.a(r101.f451183a);
            return;
        }
    }

    /* JADX INFO: renamed from: d76.b$b, reason: collision with other inner class name */
    public class C5642b implements MediaPlayer.OnErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f467257a;

        public C5642b(b r100) {
            this.f467257a = r100;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.ss.ttm.player.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer r100, int r101, int r102) {
            b r103 = this.f467257a;
            IMediaPlayer.OnErrorListener<AbsPlayer<T>> r104 = r103.f451187e;
            if (r104 == 0) goto L7;
            r104.a(r103.f451183a, r101, r102, "TTMediaPlayer on error");
            return false;
        L7:
            return false;
        }
    }

    public class c implements MediaPlayer.OnCompletionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f467258a;

        public c(b r100) {
            this.f467258a = r100;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.ss.ttm.player.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer r100) {
            b r101 = this.f467258a;
            IMediaPlayer.OnCompletionListener<AbsPlayer<T>> r102 = r101.f451185c;
            if (r102 == 0) goto L6;
            r102.a(r101.f451183a);
            return;
        }
    }

    public class d implements MediaPlayer.OnInfoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f467259a;

        public d(b r100) {
            this.f467259a = r100;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.ss.ttm.player.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer r100, int r101, int r102) {
            if (r101 != 3) goto L9;
            b r103 = this.f467259a;
            IMediaPlayer.OnFirstFrameListener<AbsPlayer<T>> r104 = r103.f451188f;
            if (r104 == 0) goto L10;
            r104.a(r103.f451183a);
            return false;
        L10:
            return false;
        L9:
            return false;
        }
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void b() throws Exception {
        TTPlayerConfiger.setValue(2, true);
        TTPlayerConfiger.setValue(1, true);
        TTPlayerConfiger.setValue(11, true);
        Context r100 = this.f467249g;
        x r101 = new x();
        monitor-enter(x.class);
    L36:
        th = move-exception;
        throw th;
    L5:
        boolean r102 = false;
        if (TTPlayerConfiger.isOnTTPlayer() == false) goto L20;
        Class r103 = x.a("com.ss.ttm.player.TTPlayerClient");     // Catch: Throwable -> L10
        Method r104 = r103.getDeclaredMethod("create", new Class[]{MediaPlayer.class, Context.class});     // Catch: Throwable -> L10
        r104.setAccessible(true);     // Catch: Throwable -> L10
        r101.f467294a = (MediaPlayerClient) r104.invoke(r103, new Object[]{r101, r100});     // Catch: Throwable -> L10
    L13:
        if (r101.f467294a != null) goto L20;
        Class r105 = x.a("com.ss.ttmplayer.player.TTPlayerClient");     // Catch: Throwable -> L17
        Method r106 = r105.getDeclaredMethod("create", new Class[]{MediaPlayer.class, Context.class});     // Catch: Throwable -> L17
        r106.setAccessible(true);     // Catch: Throwable -> L17
        r101.f467294a = (MediaPlayerClient) r106.invoke(r105, new Object[]{r101, r100});     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L36
        th.toString();     // Catch: Throwable -> L36
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L36
        th.toString();     // Catch: Throwable -> L36
    L20:
        if (r101.f467294a != null) goto L22;
        r101.f467294a = OSPlayerClient.create(r101, r100);     // Catch: Throwable -> L36
    L22:
        monitor-exit(x.class);     // Catch: Throwable -> L36
        this.f467250h = r101;
        r101.setIntOption(36, 1);
        if (Build.VERSION.SDK_INT > 23) goto L26;
    L32:
        if (r102 == false) goto L34;
        this.f467250h.setIntOption(59, 1);
    L34:
        this.f467250h.setOnPreparedListener(this.f467252j);
        this.f467250h.setOnErrorListener(this.f467253k);
        this.f467250h.setOnCompletionListener(this.f467254l);
        this.f467250h.setOnInfoListener(this.f467255m);
        return;
    L26:
        if (this.f467251i != null) goto L28;
        this.f467251i = new d76.c();
    L28:
        this.f467251i.getClass();
        ArrayList r107 = new ArrayList();
        r107.add("vivo X9");
        r107.add("VCE-AL00");
        r107.add("vivo Y79");
        r107.add("vivo X9s Plus");
        r107.add("OD1050");
        r107.add("vivo X21");
        r107.add("vivo X9s Plus L");
        r107.add("HUAWEI CAZ-AL10");
        r107.add("OPPO R9sk");
        r107.add("OPPO R11");
        r107.add("vivo X21A");
        r107.add("OPPO R9s");
        if (r107.contains(Build.MODEL) == true) goto L32;
        r102 = true;
        goto L32
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void a() {
        LLog.i("x-alpha-video", "setScreenOnWhilePlaying(true) called with player : [" + this.f467250h + "]");
        this.f467250h.setScreenOnWhilePlaying(true);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final String c() {
        return b.class.getSimpleName();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final int getCurrentPosition() {
        x r100 = this.f467250h;
        if (r100 != null) goto L7;
        LLog.e("x-alpha-video", "player is null when getCurrentPosition");
        return -1;
    L7:
        return r100.getCurrentPosition();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final VideoInfo getVideoInfo() throws Exception {
        return new VideoInfo(this.f467250h.getVideoWidth(), this.f467250h.getVideoHeight(), this.f467250h.getDuration());
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final boolean isPlaying() {
        return this.f467250h.isPlaying();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void pause() {
        LLog.i("x-alpha-video", "pause() called with player : [" + this.f467250h + "]");
        this.f467250h.pause();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void prepareAsync() {
        LLog.i("x-alpha-video", "prepareAsync() called with player : [" + this.f467250h + "]");
        this.f467250h.prepareAsync();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void release() {
        LLog.i("x-alpha-video", "release() called with player : [" + this.f467250h + "]");
        this.f467250h.release();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void reset() {
        LLog.i("x-alpha-video", "reset() called with player : [" + this.f467250h + "]");
        this.f467250h.reset();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void start() {
        LLog.i("x-alpha-video", "start() called with player : [" + this.f467250h + "]");
        this.f467250h.start();
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void stop() {
        LLog.i("x-alpha-video", "stop() called with player : [" + this.f467250h + "]");
        this.f467250h.stop();
    }

    public b(Context r100) {
        super(r100);
        this.f467252j = new a(this);
        this.f467253k = new C5642b(this);
        this.f467254l = new c(this);
        this.f467255m = new d(this);
        this.f467249g = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void seekTo(int r100) {
        x r101 = this.f467250h;
        if (r101 == null) goto L6;
        r101.seekTo(r100);
        return;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void setDataSource(String r100) throws IOException {
        LLog.i("x-alpha-video", "setDataSource() called with player : [" + this.f467250h + "]");
        if (this.f467250h.isPlaying() == false) goto L5;
        this.f467250h.stop();
    L5:
        this.f467250h.reset();
        this.f467250h.setDataSource(this.f467249g, UriProtector.parse(r100));
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void setLooping(boolean r100) {
        LLog.i("x-alpha-video", "setLooping(" + r100 + ") called with player : [" + this.f467250h + "]");
        this.f467250h.setLooping(r100);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer, com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer
    public final void setSurface(Surface r100) {
        this.f467250h.setSurface(r100);
    }
}
