package com.ss.android.lark.biz.im.api;

import android.text.TextUtils;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.content.FileState;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.image.entity.Image;
import java.io.File;

/* JADX INFO: loaded from: classes34.dex */
public final class t0 extends MessageParams<t0, a> implements n {
    public long A;
    public long B;
    public String C;
    public final File D;
    public File E;
    public String F;
    public final String G;
    public final MediaContent.Source H;
    public final String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final String f410439J;
    public final String K;
    public final boolean L;

    public static final class a extends MessageParams.a<t0, a> {
        public long A;
        public long B;
        public String C;
        public File D;
        public String E;
        public final MediaContent.Source F;
        public String G;
        public String H;
        public String I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public boolean f410440J;

        @Override // com.ss.android.lark.chat.entity.message.MessageParams.a
        public final MessageParams a() {
            this.f415276h = Message.Type.MEDIA;
            return new t0(this);
        }

        public a() {
            this.F = MediaContent.Source.LARK;
        }
    }

    @Override // com.ss.android.lark.biz.im.api.n
    public final String a() {
        return this.I;
    }

    public t0(a r100) {
        super(r100);
        this.B = r100.B;
        this.A = r100.A;
        this.C = r100.C;
        this.D = r100.D;
        String r101 = null;
        this.E = null;
        this.F = r100.E;
        this.H = r100.F;
        if (TextUtils.isEmpty(null) == false) goto L6;
        r101 = r100.D.getName();
    L6:
        this.G = r101;
        this.I = r100.G;
        this.f410439J = r100.H;
        this.K = r100.I;
        this.L = r100.f410440J;
    }

    @Override // com.ss.android.lark.chat.entity.message.MessageParams
    public final Message c(String r100, String r101) {
        Message r102 = b(r100, r101);
        MediaContent r103 = new MediaContent();
        Image r104 = new Image();
        r103.setImageSet(new ImageSet(r102.getcId(), r104, r104));
        if (TextUtils.isEmpty(this.G) == true) goto L5;
        String r105 = this.G;
    L6:
        r103.setName(r105);
        r103.setFileState(FileState.COMPRESSING);
        r103.setDuration(this.A);
        r103.setSource(this.H);
        long r106 = this.B;
        if (r106 > 0) goto L13;
        File r107 = this.D;
        if (r107 == null) goto L12;
        r106 = r107.length();
        goto L13
    L12:
        r106 = 0;
    L13:
        r103.setSize(r106);
        if (this.D == null) goto L21;
        if (TextUtils.isEmpty(this.C) == true) goto L18;
        String r108 = this.C;
    L19:
        r103.setMime(r108);
        r103.setOriginPath(this.D.getPath());
    L25:
        r103.setFilePath(r103.getOriginPath());
        r103.setCompressPath(this.F);
        r103.setFirstScreenImageUploadId(this.f410439J);
        r103.setMediaUploadId(this.K);
        r102.setMessageContent(r103);
        return r102;
    L18:
        File r109 = this.D;
        String[] r110 = FileUtils.f285888a;
        r108 = FileUtils.p(r109.getPath());
        goto L19
    L21:
        if (TextUtils.isEmpty(this.C) == true) goto L23;
        String r111 = this.C;
    L24:
        r103.setMime(r111);
        r103.setOriginPath("");
        goto L25
    L23:
        r111 = "";
        goto L24
    L5:
        r105 = this.D.getName();
        goto L6
    }
}
