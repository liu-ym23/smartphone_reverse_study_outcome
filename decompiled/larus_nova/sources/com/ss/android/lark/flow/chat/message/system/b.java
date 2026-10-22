package com.ss.android.lark.flow.chat.message.system;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.biz.im.api.extension.message.system.SystemMessageActionType;
import com.ss.android.lark.biz.im.api.extension.message.system.SystemMessageConfig;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.export.entity.message.content.ContentValue;
import com.ss.android.lark.chat.export.entity.message.content.ContentValueType;
import java.util.EnumSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements com.ss.android.lark.biz.im.api.extension.message.system.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SystemMessageActionType f422677a;

    public static final class a {
    }

    static {
    }

    public b() {
        this.f422677a = SystemMessageActionType.CONTENT_ACTION;
    }

    @Override // com.ss.android.lark.biz.im.api.extension.message.system.c
    public SystemMessageActionType getType() {
        return this.f422677a;
    }

    @Override // com.ss.android.lark.biz.im.api.extension.message.system.c
    public final com.ss.android.lark.biz.im.api.extension.message.system.b d(com.ss.android.lark.biz.im.api.extension.message.system.a r100) {
        Intrinsics.checkNotNullParameter(r100, "actionContext");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(f.class, "handlerApiClass");
        return (com.ss.android.lark.biz.im.api.extension.message.system.b) r100.a().b(f.class);
    }

    @Override // com.ss.android.lark.biz.im.api.extension.message.system.c
    public final boolean a(ContentValue r100, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.c r101) {
        Intrinsics.checkNotNullParameter(r101, "actionContext");
        if (r100 == null) goto L5;
        ContentValueType r102 = r100.getContentValueType();
    L7:
        if (r102 == ContentValueType.ACTION) goto L10;
        return false;
    L10:
        if (((EnumSet) SystemMessageConfig.f410218e.getValue()).contains(r101.f412233a.getType()) == false) goto L12;
        return false;
    L12:
        SystemContent r103 = r101.f412233a;
        if (r103.getVersion() > 0) goto L15;
        return true;
    L15:
        com.ss.android.lark.chat.export.entity.message.content.e r104 = r103.getItemActions().get(Integer.valueOf(r100.getActionId()));
        if (r104 != null) goto L18;
        return false;
    L18:
        if (r104.a() != true) goto L22;
        return true;
    L22:
        return false;
    L5:
        r102 = null;
        goto L7
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
