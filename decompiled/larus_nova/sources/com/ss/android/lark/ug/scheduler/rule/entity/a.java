package com.ss.android.lark.ug.scheduler.rule.entity;

import com.bytedance.lark.pb.ugreach.v1.LocalRule;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f444516b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RuleExpression f444517a;

    /* JADX INFO: renamed from: com.ss.android.lark.ug.scheduler.rule.entity.a$a, reason: collision with other inner class name */
    public static final class C5369a {
        @JvmStatic
        public static a a(LocalRule r100) {
            Intrinsics.checkNotNullParameter(r100, "pbLocalRule");
            r100.rule_id.longValue();
            int r101 = RuleExpression.f444503g;
            return new a(RuleExpression.a.a(r100.root_exp_node));
        }
    }

    static {
    }

    public a(RuleExpression r100) {
        this.f444517a = r100;
    }
}
