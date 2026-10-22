package s3b;

import android.text.TextUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.utils.h0;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import q3b.o;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements hya.c<String, f5b.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f5b.b f540506a;

    public class a extends com.ss.android.lark.chatbase.model.c.a<f5b.b> {
        public a(f5b.b r100) {
            super(r100);
        }

        @Override // hya.a
        public final Object a(Object r100) {
            f5b.b r101 = (f5b.b) r100;
            if (r101 == null) goto L49;
            Message.Type r102 = r101.getMessage().getType();
            if (((f5b.b) this.f416891a).getMessage().getType() != r102) goto L48;
            if (r102 != Message.Type.AUDIO) goto L16;
            AudioContent r103 = (AudioContent) r101.getMessage().getContent();
            AudioContent r104 = (AudioContent) ((f5b.b) this.f416891a).getMessage().getContent();
            if (TextUtils.isEmpty(r104.getLocalFilePath()) == false) goto L12;
            r104.setLocalFilePath(r103.getLocalFilePath());
            r104.setAudioWaveBytes(r103.getAudioWaveBytes());
        L12:
            int r105 = q3b.a.f531556a;
            if ((!FeatureGatingModule.getFeatureGatingService().isEnable("im.message.audio_text_result_disable")) == false) goto L48;
            q3b.a.a(r103, r104);
            goto L48
        L16:
            if (r102 == Message.Type.POST) goto L26;
            if (r102 == Message.Type.TEXT) goto L26;
            if (r102 == Message.Type.IMAGE) goto L26;
            if (r102 == Message.Type.MERGE_FORWARD) goto L26;
            if (h0.k(((f5b.b) this.f416891a).getMessage()) == false) goto L48;
        L26:
            if (((f5b.b) this.f416891a).getTranslateInfo() != null) goto L42;
            ((f5b.b) this.f416891a).setTranslateInfo(r101.getTranslateInfo());
            if (((f5b.b) this.f416891a).getTranslateInfo() != null) goto L30;
        L36:
            Message r106 = ((f5b.b) this.f416891a).getMessage();
            Message r107 = r101.getMessage();
            if (r106 == null) goto L42;
            if (r107 == null) goto L42;
            r106.setTranslateLanguage(r107.getTranslateLanguage());
            r106.setTranslateDisplayRule(r107.getTranslateDisplayRule());
            r106.setTranslatedManually(r107.isTranslatedManually());
            goto L42
        L30:
            if (((f5b.b) this.f416891a).getTranslateInfo().getMessageContentVersion() >= ((f5b.b) this.f416891a).getMessage().getContentVersion()) goto L36;
            Message r108 = ((f5b.b) this.f416891a).getMessage();
            Message r109 = r101.getMessage();
            if (r108 == null) goto L42;
            if (r109 == null) goto L42;
            r108.setTranslateLanguage(r109.getTranslateLanguage());
            r108.setTranslatedManually(r109.isTranslatedManually());
        L42:
            if (((f5b.b) this.f416891a).getTranslateInfo() == null) goto L45;
            ((f5b.b) this.f416891a).setIsTranslating(false);
            goto L48
        L45:
            if (((f5b.b) this.f416891a).isTranslatingInited() == true) goto L48;
            ((f5b.b) this.f416891a).setIsTranslating(r101.isTranslating());
        L48:
            return (f5b.b) this.f416891a;
        L49:
            return (f5b.b) this.f416891a;
        }
    }

    @Override // hya.c
    public final hya.a<f5b.b> a() {
        return new a(this.f540506a);
    }

    @Override // hya.c
    public final hya.b<String> b() {
        return new o(this.f540506a.getMessage());
    }

    public b(f5b.b r100) {
        this.f540506a = r100;
    }
}
