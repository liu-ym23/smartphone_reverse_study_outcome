package qja;

import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.Surface;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import fna.g;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b extends qja.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MediaPlayer f533439e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MediaMetadataRetriever f533440f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f533441g;

    public static final class a implements MediaPlayer.OnCompletionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f533442a;

        public a(b r100) {
            this.f533442a = r100;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer r100) {
            qja.c.a r101 = this.f533442a.f533435a;
            if (r101 == null) goto L6;
            r101.onCompletion();
            return;
        }
    }

    /* JADX INFO: renamed from: qja.b$b, reason: collision with other inner class name */
    public static final class C7342b implements MediaPlayer.OnPreparedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f533443a;

        public C7342b(b r100) {
            this.f533443a = r100;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer r100) {
            qja.c.d r101 = this.f533443a.f533436b;
            if (r101 == null) goto L6;
            r101.onPrepared();
            return;
        }
    }

    public static final class c implements MediaPlayer.OnErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f533444a;

        public c(b r100) {
            this.f533444a = r100;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer r100, int r101, int r102) {
            qja.c.b r103 = this.f533444a.f533437c;
            if (r103 == null) goto L7;
            r103.onError();
            return false;
        L7:
            return false;
        }
    }

    public static final class d implements MediaPlayer.OnInfoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f533445a;

        public d(b r100) {
            this.f533445a = r100;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer r100, int r101, int r102) {
            if (r101 != 3) goto L9;
            qja.c.InterfaceC7343c r103 = this.f533445a.f533438d;
            if (r103 == null) goto L10;
            r103.onFirstFrame();
            return false;
        L10:
            return false;
        L9:
            return false;
        }
    }

    @Override // qja.c
    public final void a() {
        MediaPlayer r100 = this.f533439e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r100.setScreenOnWhilePlaying(true);
    }

    @Override // qja.c
    public final void b() {
        MediaPlayer r100 = new MediaPlayer();
        this.f533439e = r100;
        r100.setOnCompletionListener(new a(this));
        MediaPlayer r101 = this.f533439e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r101.setOnPreparedListener(new C7342b(this));
        MediaPlayer r102 = this.f533439e;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L8:
        r102.setOnErrorListener(new c(this));
        MediaPlayer r103 = this.f533439e;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L11:
        r103.setOnInfoListener(new d(this));
    }

    @Override // qja.c
    public final void c() {
        MediaPlayer r100 = this.f533439e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r100.setLooping(false);
    }

    @Override // qja.c
    public final void d() {
        Intrinsics.checkNotNullParameter("nullnull", "dataPath");
        this.f533441g = "nullnull";
        MediaPlayer r100 = this.f533439e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r100.setDataSource("nullnull");
    }

    @Override // qja.c
    public final pja.c getVideoInfo() {
        String r100 = this.f533441g;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dataPath");
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L19;
        MediaMetadataRetriever r101 = this.f533440f;
        String r102 = this.f533441g;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("dataPath");
    L10:
        r101.setDataSource(r102);
        String r103 = i(this.f533440f, 18);
        String r104 = i(this.f533440f, 19);
        if (TextUtils.isEmpty(r103) == true) goto L17;
        if (TextUtils.isEmpty(r104) == true) goto L17;
        String r105 = i(this.f533440f, 18);
        Intrinsics.checkNotNull(r105);
        int r106 = CastIntegerProtector.parseInt(r105);
        String r107 = i(this.f533440f, 19);
        Intrinsics.checkNotNull(r107);
        return new pja.c(r106, CastIntegerProtector.parseInt(r107));
    L17:
        throw new Exception("DefaultSystemPlayer get metadata failure!");
    L19:
        throw new Exception("dataPath is null, please set setDataSource firstly!");
    }

    @Override // qja.c
    public final void pause() {
        MediaPlayer r100 = this.f533439e;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L6:
        if (g.d() == true) goto L8;
        r100.pause();
        return;
    L8:
        r100.pause();
        gna.a.a(r100.hashCode());
    }

    @Override // qja.c
    public final void prepareAsync() {
        MediaPlayer r100 = this.f533439e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r100.prepareAsync();
    }

    @Override // qja.c
    public final void release() {
        MediaPlayer r100 = this.f533439e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r100.release();
        this.f533441g = "";
    }

    @Override // qja.c
    public final void reset() {
        MediaPlayer r100 = this.f533439e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r100.reset();
        this.f533441g = "";
    }

    @Override // qja.c
    public final void start() {
        MediaPlayer r100 = this.f533439e;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L6:
        if (g.d() == true) goto L8;
        r100.start();
        return;
    L8:
        r100.start();
        gna.a.c(r100.hashCode());
    }

    @Override // qja.c
    public final void stop() {
        MediaPlayer r100 = this.f533439e;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L6:
        if (g.d() == true) goto L8;
        r100.stop();
        return;
    L8:
        r100.stop();
        gna.a.a(r100.hashCode());
    }

    public b() {
        this.f533440f = new MediaMetadataRetriever();
    }

    @Override // qja.c
    public final void setSurface(Surface r100) {
        Intrinsics.checkNotNullParameter(r100, "surface");
        MediaPlayer r101 = this.f533439e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r101.setSurface(r100);
    }

    public static String i(MediaMetadataRetriever r110, int r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111)};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return r110.extractMetadata(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
