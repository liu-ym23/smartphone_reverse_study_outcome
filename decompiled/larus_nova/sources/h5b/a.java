package h5b;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.widget.richtext.RichText;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends MessageParams<a, C6104a> {
    public final String A;
    public final int B;
    public final AudioContent.AudioState C;
    public final String D;
    public final String E;
    public final String F;
    public final RichText G;

    /* JADX INFO: renamed from: h5b.a$a, reason: collision with other inner class name */
    public static final class C6104a extends MessageParams.a<a, C6104a> {
        public String A;
        public int B;
        public AudioContent.AudioState C;
        public String D;
        public String E;

        public final a b() {
            this.f415276h = Message.Type.AUDIO;
            return new a(this);
        }

        @Override // com.ss.android.lark.chat.entity.message.MessageParams.a
        public final /* bridge */ /* synthetic */ MessageParams a() {
            return b();
        }

        public C6104a() {
        }
    }

    public a(C6104a r100) {
        super(r100);
        this.A = r100.A;
        this.B = r100.B;
        this.C = r100.C;
        this.D = r100.D;
        this.E = r100.E;
        this.F = null;
        this.G = null;
    }

    @Override // com.ss.android.lark.chat.entity.message.MessageParams
    public final Message c(String r100, String r101) {
        Message r102 = b(r100, r101);
        r102.setType(Message.Type.AUDIO);
        AudioContent r103 = new AudioContent();
        r103.setLocalFilePath(this.A);
        r103.setDuration(this.B);
        r103.setFileState(this.C);
        r103.setUploadId(this.D);
        r103.setAudioToken(this.E);
        if (this.F == null) goto L5;
        boolean r104 = true;
    L6:
        r103.setAudioWithText(r104);
        String r105 = this.F;
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        r103.setRecognizedText(r105);
        r103.setRecognizedRichText(this.G);
        r102.setMessageContent(r103);
        return r102;
    L5:
        r104 = false;
        goto L6
    }
}
