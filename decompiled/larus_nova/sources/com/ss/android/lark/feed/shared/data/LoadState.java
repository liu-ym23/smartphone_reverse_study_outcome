package com.ss.android.lark.feed.shared.data;

import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.obric.miniapp.alarm.AccountType;
import java.util.concurrent.atomic.AtomicBoolean;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public final class LoadState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f421125a;

    public static final enum LoadType extends Enum<LoadType> {
        public static final LoadType CONNECT = null;
        public static final LoadType LOCAL = null;
        public static final LoadType NET = null;
        public static final LoadType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoadType[] f421126a = null;
        private int value;

        static {
            LoadType r100 = new LoadType("UNKNOWN", 0, -1);
            UNKNOWN = r100;
            LoadType r101 = new LoadType(AccountType.LOCAL, 1, 0);
            LOCAL = r101;
            LoadType r102 = new LoadType("NET", 2, 1);
            NET = r102;
            LoadType r103 = new LoadType(OpenNetMethod.CONNECT, 3, 2);
            CONNECT = r103;
            f421126a = new LoadType[]{r100, r101, r102, r103};
        }

        public static LoadType[] values() {
            return (LoadType[]) f421126a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static LoadType forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return UNKNOWN;
        L10:
            return CONNECT;
        L12:
            return NET;
        L14:
            return LOCAL;
        }

        public static LoadType valueOf(String r100) {
            return (LoadType) a.a(LoadType.class, r100);
        }

        public static LoadType valueOf(int r100) {
            return forNumber(r100);
        }

        public LoadType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public LoadState() {
        new AtomicBoolean(false);
        this.f421125a = new AtomicBoolean(false);
        new AtomicBoolean(false);
    }
}
