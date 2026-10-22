package ge6;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.RemoteException;
import android.view.View;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.lynx.tasm.service.IServiceProvider;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import f06.d;
import i8a.h;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements h {
    public b() {
    }

    @Override // i8a.h
    public final void b() {
    }

    @Override // i8a.h
    public final void d() {
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    public final /* synthetic */ void onInitialize(Context r100) {
        IServiceProvider.CC.$default$onInitialize(this, r100);
    }

    @Override // i8a.h
    public final void openCamera() throws RuntimeException {
    }

    @Override // i8a.h
    public final void releaseCamera() {
    }

    @Override // i8a.h
    public final String getLocale() {
        return Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    public final Class getServiceClass() {
        return h.class;
    }

    @Override // i8a.h
    public final void a(ClipData r100) throws RemoteException {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        ClipboardManager r101 = (ClipboardManager) LarkAppContext.inst().getContext().getSystemService(ClipboardManager.class);
    L11:
        qf7.a.f532746a.a(r101, r100, new Token("LARK-PSDA-lynx_text_copy"));     // Catch: SensitiveAPIException -> L8
        return;
    L8:
        e = move-exception;
        throw new RemoteException(e.toString());
    L5:
        r101 = (ClipboardManager) LarkAppContext.inst().getContext().getSystemService(DataType.CLIPBOARD);
        goto L11
    }

    @Override // i8a.h
    public final Bitmap c(View r100, Bitmap.Config r101) {
        Bitmap r102 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), r101);
        r100.draw(new Canvas(r102));
        return r102;
    }

    @Override // i8a.h
    public final String extractMetadata(MediaMetadataRetriever r110, int r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r210)};
        f06.b r111 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r112 = r103;
        int r104 = r112.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r112[r105];
        int r113 = r105;
        int r114 = r104;
        d r107 = r106.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r111);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L20;
        return (String) r107.f474983b;
    L20:
        return r110.extractMetadata(r210);
    L14:
        r105 = r113 + 1;
        r104 = r114;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
