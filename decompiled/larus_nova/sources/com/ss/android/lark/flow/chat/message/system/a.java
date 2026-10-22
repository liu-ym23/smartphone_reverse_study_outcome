package com.ss.android.lark.flow.chat.message.system;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.biz.im.api.extension.message.system.SystemMessageActionType;
import com.ss.android.lark.biz.im.api.extension.message.system.SystemMessageConfig;
import com.ss.android.lark.chat.export.entity.message.content.ContentValue;
import com.ss.android.lark.chat.export.entity.message.content.ContentValueType;
import java.util.EnumSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements com.ss.android.lark.biz.im.api.extension.message.system.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SystemMessageActionType f422676a;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.system.a$a, reason: collision with other inner class name */
    public static final class C4980a {
    }

    static {
    }

    public a() {
        this.f422676a = SystemMessageActionType.CONTENT_ACTION;
    }

    @Override // com.ss.android.lark.biz.im.api.extension.message.system.c
    public SystemMessageActionType getType() {
        return this.f422676a;
    }

    @Override // com.ss.android.lark.biz.im.api.extension.message.system.c
    public final com.ss.android.lark.biz.im.api.extension.message.system.b d(com.ss.android.lark.biz.im.api.extension.message.system.a r100) {
        Intrinsics.checkNotNullParameter(r100, "actionContext");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(e.class, "handlerApiClass");
        return (com.ss.android.lark.biz.im.api.extension.message.system.b) r100.a().b(e.class);
    }

    @Override // com.ss.android.lark.biz.im.api.extension.message.system.c
    public final boolean a(ContentValue r100, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.c r101) {
        Intrinsics.checkNotNullParameter(r101, "actionContext");
        if (((EnumSet) SystemMessageConfig.f410217d.getValue()).contains(r101.f412233a.getType()) == false) goto L5;
        return false;
    L5:
        ContentValueType r102 = null;
        if (r100 == null) goto L8;
        ContentValueType r103 = r100.getContentValueType();
    L10:
        if (r103 == ContentValueType.USER) goto L20;
        if (r100 == null) goto L13;
        ContentValueType r104 = r100.getContentValueType();
    L15:
        if (r104 == ContentValueType.CHATTER) goto L20;
        if (r100 == null) goto L19;
        r102 = r100.getContentValueType();
    L19:
        if (r102 == ContentValueType.BOT) goto L20;
        return false;
    L13:
        r104 = null;
    L20:
        return true;
    L8:
        r103 = null;
        goto L10
    }

    @Override // com.ss.android.lark.biz.im.api.extension.message.system.c
    public final String b(ContentValue r100, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.c r101) {
        Intrinsics.checkNotNullParameter(r101, "actionContext");
        if (r100 == null) goto L6;
        String r102 = r100.getValue();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    @Override // com.ss.android.lark.biz.im.api.extension.message.system.c
    public final void c(SpannableStringBuilder r100, ContentValue r101, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.c r102) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r102, "systemActionContext");
    }
}
