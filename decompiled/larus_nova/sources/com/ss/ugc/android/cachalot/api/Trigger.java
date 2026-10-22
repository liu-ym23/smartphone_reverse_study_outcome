package com.ss.ugc.android.cachalot.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/ugc/android/cachalot/api/Trigger;", "", "", "value", "I", "getValue", "()I", "SCROLL", "SCROLL_STOP", "FIRST_SCREEN_END", "PARALLEL_REFRESH", "PREDICTION", "SERIAL_PRELOADER", "ON_SET_DATA", "ON_SET_DATA_AFTER_LOAD_MORE", "OFF_SCREEN_FORECAST", "DATA_UPDATED", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public final enum Trigger extends Enum<Trigger> {
    public static final Trigger DATA_UPDATED = null;
    public static final Trigger FIRST_SCREEN_END = null;
    public static final Trigger OFF_SCREEN_FORECAST = null;
    public static final Trigger ON_SET_DATA = null;
    public static final Trigger ON_SET_DATA_AFTER_LOAD_MORE = null;
    public static final Trigger PARALLEL_REFRESH = null;
    public static final Trigger PREDICTION = null;
    public static final Trigger SCROLL = null;
    public static final Trigger SCROLL_STOP = null;
    public static final Trigger SERIAL_PRELOADER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Trigger[] f457130a = null;
    private final int value;

    public static Trigger valueOf(String r100) {
        return (Trigger) a.a(Trigger.class, r100);
    }

    public static Trigger[] values() {
        return (Trigger[]) f457130a.clone();
    }

    static {
        Trigger r100 = new Trigger("SCROLL", 0, 0);
        SCROLL = r100;
        Trigger r101 = new Trigger("SCROLL_STOP", 1, 1);
        SCROLL_STOP = r101;
        Trigger r102 = new Trigger("FIRST_SCREEN_END", 2, 2);
        FIRST_SCREEN_END = r102;
        Trigger r103 = new Trigger("PARALLEL_REFRESH", 3, 3);
        PARALLEL_REFRESH = r103;
        Trigger r104 = new Trigger("PREDICTION", 4, 4);
        PREDICTION = r104;
        Trigger r105 = new Trigger("SERIAL_PRELOADER", 5, 5);
        SERIAL_PRELOADER = r105;
        Trigger r110 = new Trigger("ON_SET_DATA", 6, 6);
        ON_SET_DATA = r110;
        Trigger r111 = new Trigger("ON_SET_DATA_AFTER_LOAD_MORE", 7, 7);
        ON_SET_DATA_AFTER_LOAD_MORE = r111;
        Trigger r112 = new Trigger("OFF_SCREEN_FORECAST", 8, 8);
        OFF_SCREEN_FORECAST = r112;
        Trigger r113 = new Trigger("DATA_UPDATED", 9, 9);
        DATA_UPDATED = r113;
        f457130a = new Trigger[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public final int getValue() {
        return this.value;
    }

    public Trigger(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
