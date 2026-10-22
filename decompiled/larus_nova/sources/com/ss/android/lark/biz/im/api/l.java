package com.ss.android.lark.biz.im.api;

import android.net.Uri;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.FileState;

/* JADX INFO: loaded from: classes34.dex */
public final class l extends MessageParams<l, a> implements n {
    public final String A;
    public String B;
    public final String C;
    public final String D;
    public final long E;
    public final String F;
    public final FileState G;
    public final String H;
    public Uri I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final String f410266J;
    public final k K;

    public static final class a extends MessageParams.a<l, a> {
        public String A;
        public String B;
        public String C;
        public long D;
        public String E;
        public FileState F;
        public Uri G;
        public String H;
        public String I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public k f410267J;

        public final l b() {
            this.f415276h = Message.Type.FILE;
            return new l(this);
        }

        public a() {
            this.B = "";
            this.C = "";
            this.F = FileState.UPLOADING;
        }

        @Override // com.ss.android.lark.chat.entity.message.MessageParams.a
        public final /* bridge */ /* synthetic */ MessageParams a() {
            return b();
        }
    }

    @Override // com.ss.android.lark.biz.im.api.n
    public final String a() {
        return this.H;
    }

    public l(a r100) {
        super(r100);
        this.A = r100.A;
        this.B = null;
        this.C = r100.B;
        this.D = r100.C;
        this.E = r100.D;
        String r101 = r100.E;
        if (r101 == null) goto L5;
        this.F = r101;
    L6:
        this.G = r100.F;
        this.I = r100.G;
        this.H = r100.H;
        this.f410266J = r100.I;
        this.K = r100.f410267J;
        return;
    L5:
        this.F = "*/*";
        goto L6
    }

    @Override // com.ss.android.lark.chat.entity.message.MessageParams
    public final Message c(String r100, String r101) {
        Message r102 = b(r100, r101);
        r102.setType(Message.Type.FILE);
        r102.setRootId("");
        r102.setParentId("");
        FileContent r103 = new FileContent();
        r103.setFilePath(this.A);
        Uri r104 = this.I;
        if (r104 == null) goto L5;
        String r105 = r104.toString();
    L6:
        r103.setUriString(r105);
        r103.setName(this.C);
        r103.setKey(this.D);
        r103.setMime(this.F);
        r103.setSize(this.E);
        r103.setSource(0);
        r103.setFileState(this.G);
        r103.setNameSpace(null);
        r103.setFileUploadId(this.f410266J);
        r102.setMessageContent(r103);
        return r102;
    L5:
        r105 = null;
        goto L6
    }
}
