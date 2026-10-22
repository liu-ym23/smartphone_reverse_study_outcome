package com.larksuite.component.universe_design.badge;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class UDBadge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f284492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f284493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f284494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f284495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f284496e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larksuite/component/universe_design/badge/UDBadge$BadgeType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DOT", CardAdapter.TEXT, "ICON", "universe-ui-badge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BadgeType extends Enum<BadgeType> {
        public static final BadgeType DOT = null;
        public static final BadgeType ICON = null;
        public static final BadgeType TEXT = null;
        public static final BadgeType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BadgeType[] f284497a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f284498b = null;
        private final int value;

        public static EnumEntries<BadgeType> getEntries() {
            return f284498b;
        }

        static {
            BadgeType r100 = new BadgeType("UNKNOWN", 0, -1);
            UNKNOWN = r100;
            BadgeType r101 = new BadgeType("DOT", 1, 0);
            DOT = r101;
            BadgeType r102 = new BadgeType(CardAdapter.TEXT, 2, 1);
            TEXT = r102;
            BadgeType r103 = new BadgeType("ICON", 3, 2);
            ICON = r103;
            BadgeType[] r104 = {r100, r101, r102, r103};
            f284497a = r104;
            f284498b = EnumEntriesKt.enumEntries(r104);
        }

        public static BadgeType[] values() {
            return (BadgeType[]) f284497a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static BadgeType valueOf(String r100) {
            return (BadgeType) r27.a.a(BadgeType.class, r100);
        }

        public BadgeType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Paint f284499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f284500b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Paint f284501c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final RectF f284502d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final PointF f284503e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final RectF f284504f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ UDBadge f284505g;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f284506a = null;

            static {
                int[] r100 = new int[BadgeType.values().length];
                r100[BadgeType.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[BadgeType.ICON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f284506a = r100;
            }
        }

        public b(UDBadge r100) {
            this.f284505g = r100;
            Paint r101 = new Paint();
            r101.setAntiAlias(true);
            this.f284499a = r101;
            Paint r102 = new Paint();
            r102.setAntiAlias(true);
            this.f284500b = r102;
            Paint r103 = new Paint();
            r103.setAntiAlias(true);
            w08.a.a(r103, r100.f284492a, 1);
            this.f284501c = r103;
            this.f284502d = new RectF();
            this.f284503e = new PointF();
            this.f284504f = new RectF();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BadgeType f284507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f284508b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f284509c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f284510d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f284511e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f284512f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f284513g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f284514h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f284515i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f284516j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f284517k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Drawable f284518l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public RectF f284519m;

        public c() {
            this.f284507a = BadgeType.UNKNOWN;
        }

        public final void update(c r100) {
            Intrinsics.checkNotNullParameter(r100, "newModel");
            this.f284507a = r100.f284507a;
            this.f284508b = r100.f284508b;
            this.f284509c = r100.f284509c;
            this.f284510d = r100.f284510d;
            this.f284511e = r100.f284511e;
            this.f284512f = r100.f284512f;
            this.f284513g = r100.f284513g;
            this.f284514h = r100.f284514h;
            this.f284515i = r100.f284515i;
            this.f284516j = r100.f284516j;
            this.f284517k = r100.f284517k;
            this.f284518l = r100.f284518l;
            this.f284519m = r100.f284519m;
        }
    }

    static {
    }

    public UDBadge(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f284492a = r100;
        this.f284493b = new c();
        this.f284494c = new b(this);
    }

    public static final float a(UDBadge r100) {
        float r101 = 0.0f - (r100.f284495d / 2);
        if (r101 >= 0.0f) goto L6;
        return 0.0f;
    L6:
        return r101;
    }

    public static final float b(UDBadge r100) {
        float r101 = 0.0f - (r100.f284496e / 2);
        if (r101 >= 0.0f) goto L6;
        return 0.0f;
    L6:
        return r101;
    }
}
