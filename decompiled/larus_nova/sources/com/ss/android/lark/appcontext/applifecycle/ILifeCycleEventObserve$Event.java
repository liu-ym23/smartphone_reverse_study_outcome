package com.ss.android.lark.appcontext.applifecycle;

/* JADX INFO: loaded from: classes34.dex */
public final enum ILifeCycleEventObserve$Event extends Enum<ILifeCycleEventObserve$Event> {
    public static final ILifeCycleEventObserve$Event FIRST_CONTENT_SHOWED = null;
    public static final ILifeCycleEventObserve$Event FIRST_DATA_LOADED = null;
    public static final ILifeCycleEventObserve$Event FIRST_FRAME_SHOWED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ILifeCycleEventObserve$Event[] f408815a = null;

    static {
        ILifeCycleEventObserve$Event r100 = new ILifeCycleEventObserve$Event("FIRST_CONTENT_SHOWED", 0);
        FIRST_CONTENT_SHOWED = r100;
        ILifeCycleEventObserve$Event r101 = new ILifeCycleEventObserve$Event("FIRST_FRAME_SHOWED", 1);
        FIRST_FRAME_SHOWED = r101;
        ILifeCycleEventObserve$Event r102 = new ILifeCycleEventObserve$Event("FIRST_DATA_LOADED", 2);
        FIRST_DATA_LOADED = r102;
        f408815a = new ILifeCycleEventObserve$Event[]{r100, r101, r102};
    }

    public static ILifeCycleEventObserve$Event[] values() {
        return (ILifeCycleEventObserve$Event[]) f408815a.clone();
    }

    public static ILifeCycleEventObserve$Event valueOf(String r100) {
        return (ILifeCycleEventObserve$Event) r27.a.a(ILifeCycleEventObserve$Event.class, r100);
    }

    public ILifeCycleEventObserve$Event(String r100, int r101) {
        super(r100, r101);
    }
}
