package com.ss.android.lark.biz.im.api;

import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.image.entity.Image;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes34.dex */
public final class p0 extends MessageParams<p0, a> implements n {
    public final String A;
    public final int B;
    public final int C;
    public final boolean D;
    public final boolean E;
    public final String F;
    public final String G;

    public static final class a extends MessageParams.a<p0, a> {
        public String A;
        public int B;
        public int C;
        public boolean D;
        public boolean E;
        public String F;
        public String G;

        @Override // com.ss.android.lark.chat.entity.message.MessageParams.a
        public final MessageParams a() {
            this.f415276h = Message.Type.IMAGE;
            return new p0(this);
        }

        public a() {
        }
    }

    @Override // com.ss.android.lark.biz.im.api.n
    public final String a() {
        return this.F;
    }

    public p0(a r100) {
        super(r100);
        this.A = r100.A;
        this.B = r100.B;
        this.C = r100.C;
        this.D = r100.D;
        this.E = r100.E;
        this.F = r100.F;
        this.G = r100.G;
    }

    @Override // com.ss.android.lark.chat.entity.message.MessageParams
    public final Message c(String r100, String r101) {
        Message r102 = b(r100, r101);
        r102.setType(Message.Type.IMAGE);
        Image r103 = new Image();
        r103.setWidth(this.B);
        r103.setHeight(this.C);
        r103.setUrls(new ArrayList(Collections.singletonList(this.A)));
        ImageContent r104 = new ImageContent(new ImageSet(r102.getcId(), r103, r103));
        r104.setProgress(0);
        r104.setImageUploadId(this.G);
        r102.setMessageContent(r104);
        return r102;
    }
}
