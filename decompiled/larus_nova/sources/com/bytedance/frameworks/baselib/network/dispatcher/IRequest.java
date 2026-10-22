package com.bytedance.frameworks.baselib.network.dispatcher;

import com.ss.android.ugc.effectmanager.common.EffectConstants;

/* JADX INFO: loaded from: classes3.dex */
public interface IRequest {

    public static final enum Priority extends Enum<Priority> {
        public static final Priority HIGH = null;
        public static final Priority IMMEDIATE = null;
        public static final Priority LOW = null;
        public static final Priority LOWEST = null;
        public static final Priority NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Priority[] f244652a = null;

        static {
            Priority r100 = new Priority("LOWEST", 0);
            LOWEST = r100;
            Priority r101 = new Priority("LOW", 1);
            LOW = r101;
            Priority r102 = new Priority(EffectConstants.NORMAL, 2);
            NORMAL = r102;
            Priority r103 = new Priority("HIGH", 3);
            HIGH = r103;
            Priority r104 = new Priority("IMMEDIATE", 4);
            IMMEDIATE = r104;
            f244652a = new Priority[]{r100, r101, r102, r103, r104};
        }

        public static Priority[] values() {
            return (Priority[]) f244652a.clone();
        }

        public static Priority valueOf(String r100) {
            return (Priority) r27.a.a(Priority.class, r100);
        }

        public Priority(String r100, int r101) {
            super(r100, r101);
        }
    }

    int a();

    Priority getPriority();
}
