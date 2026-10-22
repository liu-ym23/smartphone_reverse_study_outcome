package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.bytedance.lark.pb.space.doc.v1.RemoveDocRequest;
import com.bytedance.lark.pb.space.doc.v1.UpdateDocMeReadRequest;
import com.bytedance.lark.pb.space.doc.v1.UpdateDocMessageBadgeRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.sdk.SdkSender;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class BadgeAgentImpl implements com.bytedance.ee.bear.contract.g.a {
    public BadgeAgentImpl() {
    }

    @Override // com.bytedance.ee.bear.contract.g
    public final void remove(String r100) {
        IGetDataCallback<Boolean> r101 = new AnonymousClass3(this);
        tt5.a.h("BadgeAgentImpl", "remove doc: ");
        RemoveDocRequest.Builder r102 = new RemoveDocRequest.Builder().token(r100);
        SdkSender.asynSendRequestNonWrap(Command.REMOVE_DOC, r102, r101, new k());
    }

    @Override // com.bytedance.ee.bear.contract.g
    public final void a(String r100, int r101, final List<String> r102) {
        DocType r103 = DocType.UNKNOWN_DOC_TYPE;
        if (r101 != sbb.e.f541296g.f541317b) goto L6;
        r103 = DocType.DOC;
    L26:
        IGetDataCallback<Boolean> r104 = new AnonymousClass1(this, r102);
        UpdateDocMeReadRequest.Builder r105 = new UpdateDocMeReadRequest.Builder().doc_type(Doc.Type.fromValue(r103.getNumber())).message_ids(r102).token(r100);
        SdkSender.asynSendRequestNonWrap(Command.UPDATE_DOC_ME_READ, r105, r104, new j());
        return;
    L6:
        if (r101 != sbb.e.f541297h.f541317b) goto L9;
        r103 = DocType.SHEET;
        goto L26
    L9:
        if (r101 != sbb.e.f541298i.f541317b) goto L12;
        r103 = DocType.BITABLE;
        goto L26
    L12:
        if (r101 != sbb.e.f541301l.f541317b) goto L15;
        r103 = DocType.FILE;
        goto L26
    L15:
        if (r101 != sbb.e.f541300k.f541317b) goto L18;
        r103 = DocType.MINDNOTE;
        goto L26
    L18:
        if (r101 != sbb.e.f541302m.f541317b) goto L21;
        r103 = DocType.SLIDES;
        goto L26
    L21:
        if (r101 != sbb.e.f541304o.f541317b) goto L24;
        r103 = DocType.DOCX;
        goto L26
    L24:
        if (r101 != sbb.e.f541314y.f541317b) goto L26;
        r103 = DocType.DOCX_SYNCED_BLOCK;
        goto L26
    }

    @Override // com.bytedance.ee.bear.contract.g
    public final void b(String r100, final long r101, final long r110) {
        IGetDataCallback<Boolean> r102 = new AnonymousClass5(this, r101, r110);
        tt5.a.h("BadgeAgentImpl", "update badge:" + r101 + ", version=" + r110);
        SdkSender.asynSendRequestNonWrap(Command.UPDATE_DOC_MESSAGE_BADGE, new UpdateDocMessageBadgeRequest.Builder().token(r100).new_message_count(Integer.valueOf((int) r101)).version(Integer.valueOf((int) r110)), r102, new l());
    }
}
