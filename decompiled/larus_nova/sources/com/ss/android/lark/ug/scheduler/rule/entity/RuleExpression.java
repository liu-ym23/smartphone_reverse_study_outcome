package com.ss.android.lark.ug.scheduler.rule.entity;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.ss.android.lark.ug.scheduler.common.exception.RuleException;
import com.ss.android.lark.ug.scheduler.common.exception.RuleMetricErrorInfo;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class RuleExpression {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f444503g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f444504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f444505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RuleExpression f444506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RuleExpression f444507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ConditionOperator f444508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ExpressionOperator f444509f;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/ug/scheduler/rule/entity/RuleExpression$ConditionOperator;", "", "value", "", "comparator", "Lkotlin/Function2;", "", "<init>", "(Ljava/lang/String;IILkotlin/jvm/functions/Function2;)V", "getValue", "()I", "UNKNOWN", "AND", "OR", "NOT", "compare", "left", "right", "Companion", "ug-reach-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ConditionOperator extends Enum<ConditionOperator> {
        public static final ConditionOperator AND = null;
        public static final a Companion = null;
        public static final ConditionOperator NOT = null;
        public static final ConditionOperator OR = null;
        public static final ConditionOperator UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ConditionOperator[] f444510a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f444511b = null;
        private final Function2<Boolean, Boolean, Boolean> comparator;
        private final int value;

        public static final class a {

            /* JADX INFO: renamed from: com.ss.android.lark.ug.scheduler.rule.entity.RuleExpression$ConditionOperator$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C5367a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f444512a = null;

                static {
                    int[] r100 = new int[com.bytedance.lark.pb.ugreach.v1.RuleExpression.ConditionOperator.values().length];
                    r100[com.bytedance.lark.pb.ugreach.v1.RuleExpression.ConditionOperator.AND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
                L11:
                    r100[com.bytedance.lark.pb.ugreach.v1.RuleExpression.ConditionOperator.OR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
                L15:
                    r100[com.bytedance.lark.pb.ugreach.v1.RuleExpression.ConditionOperator.NOT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
                L6:
                    f444512a = r100;
                }
            }

            public a() {
            }
        }

        public static EnumEntries<ConditionOperator> getEntries() {
            return f444511b;
        }

        static {
            ConditionOperator r100 = new ConditionOperator("UNKNOWN", 0, 0, AnonymousClass1.INSTANCE);
            UNKNOWN = r100;
            ConditionOperator r101 = new ConditionOperator("AND", 1, 1, AnonymousClass2.INSTANCE);
            AND = r101;
            ConditionOperator r102 = new ConditionOperator("OR", 2, 2, AnonymousClass3.INSTANCE);
            OR = r102;
            ConditionOperator r103 = new ConditionOperator("NOT", 3, 3, AnonymousClass4.INSTANCE);
            NOT = r103;
            ConditionOperator[] r104 = {r100, r101, r102, r103};
            f444510a = r104;
            f444511b = EnumEntriesKt.enumEntries(r104);
            Companion = new a();
        }

        public static ConditionOperator[] values() {
            return (ConditionOperator[]) f444510a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ConditionOperator valueOf(String r100) {
            return (ConditionOperator) r27.a.a(ConditionOperator.class, r100);
        }

        public final boolean compare(boolean r100, boolean r101) {
            return this.comparator.invoke(Boolean.valueOf(r100), Boolean.valueOf(r101)).booleanValue();
        }

        public ConditionOperator(String r100, int r101, int r102, Function2 r103) {
            super(r100, r101);
            this.value = r102;
            this.comparator = r103;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/ug/scheduler/rule/entity/RuleExpression$ExpressionOperator;", "", "value", "", "comparator", "Lkotlin/Function2;", "", "", "<init>", "(Ljava/lang/String;IILkotlin/jvm/functions/Function2;)V", "getValue", "()I", "UNKNOWN", "IN", "EQUAL", "NOT_EQUAL", "LESS_OR_EQUAL", "LESS_THAN", "GREATER_OR_EQUAL", "GREATER_THAN", "compare", "currentValue", "thresholdValue", "Companion", "ug-reach-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ExpressionOperator extends Enum<ExpressionOperator> {
        public static final a Companion = null;
        public static final ExpressionOperator EQUAL = null;
        public static final ExpressionOperator GREATER_OR_EQUAL = null;
        public static final ExpressionOperator GREATER_THAN = null;
        public static final ExpressionOperator IN = null;
        public static final ExpressionOperator LESS_OR_EQUAL = null;
        public static final ExpressionOperator LESS_THAN = null;
        public static final ExpressionOperator NOT_EQUAL = null;
        public static final ExpressionOperator UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ExpressionOperator[] f444513a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f444514b = null;
        private final Function2<String, String, Boolean> comparator;
        private final int value;

        public static final class a {

            /* JADX INFO: renamed from: com.ss.android.lark.ug.scheduler.rule.entity.RuleExpression$ExpressionOperator$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C5368a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f444515a = null;

                static {
                    int[] r100 = new int[com.bytedance.lark.pb.ugreach.v1.RuleExpression.ExpressionOperator.values().length];
                    r100[com.bytedance.lark.pb.ugreach.v1.RuleExpression.ExpressionOperator.IN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
                L21:
                    r100[com.bytedance.lark.pb.ugreach.v1.RuleExpression.ExpressionOperator.EQUAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
                L31:
                    r100[com.bytedance.lark.pb.ugreach.v1.RuleExpression.ExpressionOperator.NOT_EQUAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
                L23:
                    r100[com.bytedance.lark.pb.ugreach.v1.RuleExpression.ExpressionOperator.LESS_OR_EQUAL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
                L25:
                    r100[com.bytedance.lark.pb.ugreach.v1.RuleExpression.ExpressionOperator.LESS_THAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
                L19:
                    r100[com.bytedance.lark.pb.ugreach.v1.RuleExpression.ExpressionOperator.GREATER_OR_EQUAL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
                L27:
                    r100[com.bytedance.lark.pb.ugreach.v1.RuleExpression.ExpressionOperator.GREATER_THAN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
                L10:
                    f444515a = r100;
                }
            }

            public a() {
            }

            public static int a(String r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "left");
                Intrinsics.checkNotNullParameter(r101, "right");
                return Intrinsics.compare(CastIntegerProtector.parseInt(r100), CastIntegerProtector.parseInt(r101));
            L5:
                e = move-exception;
                RuleException r102 = new RuleException(RuleMetricErrorInfo.ILLEGAL_THRESHOLD, e);
                r102.setExtraInfo(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("value", "left:" + r100 + ", right:" + r101)}));
                throw r102;
            }
        }

        public static EnumEntries<ExpressionOperator> getEntries() {
            return f444514b;
        }

        static {
            ExpressionOperator r100 = new ExpressionOperator("UNKNOWN", 0, 0, AnonymousClass1.INSTANCE);
            UNKNOWN = r100;
            ExpressionOperator r101 = new ExpressionOperator("IN", 1, 1, AnonymousClass2.INSTANCE);
            IN = r101;
            ExpressionOperator r102 = new ExpressionOperator("EQUAL", 2, 2, AnonymousClass3.INSTANCE);
            EQUAL = r102;
            ExpressionOperator r103 = new ExpressionOperator("NOT_EQUAL", 3, 3, AnonymousClass4.INSTANCE);
            NOT_EQUAL = r103;
            ExpressionOperator r104 = new ExpressionOperator("LESS_OR_EQUAL", 4, 4, AnonymousClass5.INSTANCE);
            LESS_OR_EQUAL = r104;
            ExpressionOperator r105 = new ExpressionOperator("LESS_THAN", 5, 5, AnonymousClass6.INSTANCE);
            LESS_THAN = r105;
            ExpressionOperator r110 = new ExpressionOperator("GREATER_OR_EQUAL", 6, 6, AnonymousClass7.INSTANCE);
            GREATER_OR_EQUAL = r110;
            ExpressionOperator r111 = new ExpressionOperator("GREATER_THAN", 7, 7, AnonymousClass8.INSTANCE);
            GREATER_THAN = r111;
            ExpressionOperator[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
            f444513a = r112;
            f444514b = EnumEntriesKt.enumEntries(r112);
            Companion = new a();
        }

        public static ExpressionOperator[] values() {
            return (ExpressionOperator[]) f444513a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ExpressionOperator valueOf(String r100) {
            return (ExpressionOperator) r27.a.a(ExpressionOperator.class, r100);
        }

        public final boolean compare(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "currentValue");
            Intrinsics.checkNotNullParameter(r101, "thresholdValue");
            return this.comparator.invoke(r100, r101).booleanValue();
        }

        public ExpressionOperator(String r100, int r101, int r102, Function2 r103) {
            super(r100, r101);
            this.value = r102;
            this.comparator = r103;
        }
    }

    public static final class a {
        @JvmStatic
        public static RuleExpression a(com.bytedance.lark.pb.ugreach.v1.RuleExpression r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            RuleExpression r101 = a(r100.left);
            RuleExpression r102 = a(r100.right);
            if (r101 != null) goto L20;
            if (r102 != null) goto L20;
            String r103 = r100.rule_action;
            String r104 = r100.value;
            ExpressionOperator.a r105 = ExpressionOperator.Companion;
            com.bytedance.lark.pb.ugreach.v1.RuleExpression.ExpressionOperator r106 = r100.exp_operator;
            r105.getClass();
            Intrinsics.checkNotNullParameter(r106, OnekeyLoginConstants.CU_KEY_OPERATOR);
            switch(ExpressionOperator.a.C5368a.f444515a[r106.ordinal()]) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                default: goto L10;
            };
        L10:
            ExpressionOperator r107 = ExpressionOperator.UNKNOWN;
        L18:
            Intrinsics.checkNotNullParameter(r103, "ruleAction");
            Intrinsics.checkNotNullParameter(r104, "thresholdValue");
            Intrinsics.checkNotNullParameter(r107, "expressionOperator");
            RuleExpression r108 = new RuleExpression();
            r108.f444509f = r107;
            r108.f444504a = r103;
            r108.f444505b = r104;
            return r108;
        L11:
            r107 = ExpressionOperator.GREATER_THAN;
            goto L18
        L12:
            r107 = ExpressionOperator.GREATER_OR_EQUAL;
            goto L18
        L13:
            r107 = ExpressionOperator.LESS_THAN;
            goto L18
        L14:
            r107 = ExpressionOperator.LESS_OR_EQUAL;
            goto L18
        L15:
            r107 = ExpressionOperator.NOT_EQUAL;
            goto L18
        L16:
            r107 = ExpressionOperator.EQUAL;
            goto L18
        L17:
            r107 = ExpressionOperator.IN;
        L20:
            ConditionOperator.a r109 = ConditionOperator.Companion;
            com.bytedance.lark.pb.ugreach.v1.RuleExpression.ConditionOperator r110 = r100.cond_operator;
            r109.getClass();
            Intrinsics.checkNotNullParameter(r110, OnekeyLoginConstants.CU_KEY_OPERATOR);
            int r111 = ConditionOperator.a.C5367a.f444512a[r110.ordinal()];
            if (r111 != 1) goto L23;
            ConditionOperator r112 = ConditionOperator.AND;
        L30:
            Intrinsics.checkNotNullParameter(r112, "conditionOperator");
            RuleExpression r113 = new RuleExpression();
            r113.f444506c = r101;
            r113.f444507d = r102;
            r113.f444508e = r112;
            return r113;
        L23:
            if (r111 != 2) goto L25;
            r112 = ConditionOperator.OR;
            goto L30
        L25:
            if (r111 == 3) goto L27;
            r112 = ConditionOperator.UNKNOWN;
            goto L30
        L27:
            r112 = ConditionOperator.NOT;
            goto L30
        }
    }

    static {
    }

    public RuleExpression() {
    }
}
