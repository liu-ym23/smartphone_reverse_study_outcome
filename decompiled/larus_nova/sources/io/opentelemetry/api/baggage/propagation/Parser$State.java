package io.opentelemetry.api.baggage.propagation;

import r27.a;

/* JADX INFO: loaded from: classes41.dex */
final enum Parser$State extends Enum<Parser$State> {
    public static final Parser$State KEY = null;
    public static final Parser$State META = null;
    public static final Parser$State VALUE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Parser$State[] f492661a = null;

    static {
        Parser$State r100 = new Parser$State("KEY", 0);
        KEY = r100;
        Parser$State r101 = new Parser$State("VALUE", 1);
        VALUE = r101;
        Parser$State r102 = new Parser$State("META", 2);
        META = r102;
        f492661a = new Parser$State[]{r100, r101, r102};
    }

    public static Parser$State[] values() {
        return (Parser$State[]) f492661a.clone();
    }

    public static Parser$State valueOf(String r100) {
        return (Parser$State) a.a(Parser$State.class, r100);
    }

    public Parser$State(String r100, int r101) {
        super(r100, r101);
    }
}
