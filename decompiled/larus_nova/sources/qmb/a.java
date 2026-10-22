package qmb;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.lark.biz.im.extension.message_action.FeatureScopeInterceptorType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.message.Message;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yya.e;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<MessageActionType> f533976a;

    public a() {
        this.f533976a = CollectionsKt.listOf(new MessageActionType[]{MessageActionType.FLOW_LIKE, MessageActionType.FLOW_DISLIKE, MessageActionType.FLOW_FEEDBACK});
    }

    @Override // yya.l
    public final String getTAG() {
        return e.a.a(this);
    }

    @Override // yya.e
    public FeatureScopeInterceptorType getType() {
        return FeatureScopeInterceptorType.FLOW_COMMON;
    }

    @Override // yya.l
    public final boolean a(MessageActionType r100, yya.a r101) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r101, "actionContext");
        if (r101.m().getType() != Message.Type.DOUBAO) goto L5;
    L8:
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r101, "actionContext");
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r101, "actionContext");
        return false;
    L5:
        if (this.f533976a.contains(r100) == false) goto L8;
        return true;
    }

    @Override // yya.e
    public final boolean b(MessageActionType r100, yya.a r101) {
        e.a.c(r100, r101);
        return false;
    }

    @Override // yya.e
    public final boolean c(MessageActionType r100, yya.a r101, boolean r102) {
        e.a.b(r100, r101);
        return false;
    }
}
