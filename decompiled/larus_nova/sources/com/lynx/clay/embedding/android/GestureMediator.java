package com.lynx.clay.embedding.android;

import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.lynx.clay.embedding.engine.FlutterEngine;

/* JADX INFO: loaded from: classes32.dex */
public final class GestureMediator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterView f380568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlutterEngine f380569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f380570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VelocityTracker f380571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f380572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f380573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f380574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f380575h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f380576i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f380577j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f380578k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f380579l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f380580m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f380581n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f380582o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public GestureMediateState f380583p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f380584q;

    public static final enum GestureMediateState extends Enum<GestureMediateState> {
        public static final GestureMediateState BLOCKING_MEDIATING = null;
        public static final GestureMediateState IDLE = null;
        public static final GestureMediateState INNER_WIN = null;
        public static final GestureMediateState MEDIATING = null;
        public static final GestureMediateState OUTER_WIN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GestureMediateState[] f380585a = null;

        static {
            GestureMediateState r100 = new GestureMediateState("IDLE", 0);
            IDLE = r100;
            GestureMediateState r101 = new GestureMediateState("MEDIATING", 1);
            MEDIATING = r101;
            GestureMediateState r102 = new GestureMediateState("BLOCKING_MEDIATING", 2);
            BLOCKING_MEDIATING = r102;
            GestureMediateState r103 = new GestureMediateState("INNER_WIN", 3);
            INNER_WIN = r103;
            GestureMediateState r104 = new GestureMediateState("OUTER_WIN", 4);
            OUTER_WIN = r104;
            f380585a = new GestureMediateState[]{r100, r101, r102, r103, r104};
        }

        public static GestureMediateState[] values() {
            return (GestureMediateState[]) f380585a.clone();
        }

        public static GestureMediateState valueOf(String r100) {
            return (GestureMediateState) r27.a.a(GestureMediateState.class, r100);
        }

        public GestureMediateState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f380586a = null;

        static {
            int[] r100 = new int[GestureMediateState.values().length];
            f380586a = r100;
            r100[GestureMediateState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f380586a[GestureMediateState.MEDIATING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f380586a[GestureMediateState.OUTER_WIN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f380586a[GestureMediateState.INNER_WIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f380586a[GestureMediateState.BLOCKING_MEDIATING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public final void a(GestureMediateState r100) {
        if (this.f380583p != r100) goto L5;
        return;
    L5:
        this.f380583p = r100;
        int r101 = a.f380586a[r100.ordinal()];
        if (r101 != 1) goto L8;
    L17:
        this.f380568a.getParent().requestDisallowInterceptTouchEvent(false);
        return;
    L8:
        if (r101 == 2) goto L17;
        if (r101 == 3) goto L17;
        if (r101 != 4) goto L14;
    L16:
        this.f380568a.getParent().requestDisallowInterceptTouchEvent(true);
        return;
    L14:
        if (r101 == 5) goto L16;
    }

    public GestureMediator(FlutterView r100, FlutterEngine r101, b r102) {
        this.f380572e = false;
        this.f380574g = 0;
        this.f380575h = 0;
        this.f380576i = 0;
        this.f380577j = 0;
        this.f380578k = 0;
        this.f380581n = 0;
        this.f380582o = 0;
        this.f380583p = GestureMediateState.IDLE;
        this.f380584q = false;
        this.f380568a = r100;
        this.f380569b = r101;
        this.f380570c = r102;
        this.f380573f = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
    }
}
