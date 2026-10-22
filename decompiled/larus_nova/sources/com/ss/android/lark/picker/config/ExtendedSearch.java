package com.ss.android.lark.picker.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/config/ExtendedSearch;", "", "<init>", "()V", "CLOSE", "OPEN", "Lcom/ss/android/lark/picker/config/ExtendedSearch$CLOSE;", "Lcom/ss/android/lark/picker/config/ExtendedSearch$OPEN;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ExtendedSearch {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/config/ExtendedSearch$CLOSE;", "Lcom/ss/android/lark/picker/config/ExtendedSearch;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CLOSE extends ExtendedSearch {
        public static final CLOSE INSTANCE = null;

        static {
            INSTANCE = new CLOSE();
        }

        private CLOSE() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/config/ExtendedSearch$OPEN;", "Lcom/ss/android/lark/picker/config/ExtendedSearch;", "isUseV2", "", "<init>", "(Z)V", "()V", "()Z", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OPEN extends ExtendedSearch {
        private final boolean isUseV2;

        public OPEN() {
            this(false);
        }

        public final boolean isUseV2() {
            return this.isUseV2;
        }

        public OPEN(boolean r100) {
            super(null);
            this.isUseV2 = r100;
        }
    }

    private ExtendedSearch() {
    }

    public /* synthetic */ ExtendedSearch(DefaultConstructorMarker r100) {
        this();
    }
}
