package com.larus.dora.impl.device.ailab.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/dora/impl/device/ailab/config/AutoStopTimeConfig;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FIVE_SECONDS", "EIGHT_SECONDS", "TWELVE_SECONDS", "TWENTY_SECONDS", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AutoStopTimeConfig extends Enum<AutoStopTimeConfig> {
    public static final a Companion = null;
    public static final AutoStopTimeConfig EIGHT_SECONDS = null;
    public static final AutoStopTimeConfig FIVE_SECONDS = null;
    public static final AutoStopTimeConfig TWELVE_SECONDS = null;
    public static final AutoStopTimeConfig TWENTY_SECONDS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AutoStopTimeConfig[] f333537a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f333538b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static List a(boolean r100) {
            EnumEntries<AutoStopTimeConfig> r101 = AutoStopTimeConfig.getEntries();
            ArrayList r102 = new ArrayList();
            Iterator<AutoStopTimeConfig> r103 = r101.iterator();
        L4:
            if (r103.hasNext() == false) goto L14;
            AutoStopTimeConfig r104 = r103.next();
            AutoStopTimeConfig r105 = r104;
            if (r100 == true) goto L8;
        L11:
            boolean r106 = true;
        L12:
            if (r106 == false) goto L4;
            r102.add(r104);
            goto L4
        L8:
            if (r105 != AutoStopTimeConfig.FIVE_SECONDS) goto L11;
            r106 = false;
            goto L12
        L14:
            return r102;
        }
    }

    public static EnumEntries<AutoStopTimeConfig> getEntries() {
        return f333538b;
    }

    static {
        AutoStopTimeConfig r100 = new AutoStopTimeConfig("FIVE_SECONDS", 0, 5);
        FIVE_SECONDS = r100;
        AutoStopTimeConfig r101 = new AutoStopTimeConfig("EIGHT_SECONDS", 1, 8);
        EIGHT_SECONDS = r101;
        AutoStopTimeConfig r102 = new AutoStopTimeConfig("TWELVE_SECONDS", 2, 12);
        TWELVE_SECONDS = r102;
        AutoStopTimeConfig r103 = new AutoStopTimeConfig("TWENTY_SECONDS", 3, 20);
        TWENTY_SECONDS = r103;
        AutoStopTimeConfig[] r104 = {r100, r101, r102, r103};
        f333537a = r104;
        f333538b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static AutoStopTimeConfig[] values() {
        return (AutoStopTimeConfig[]) f333537a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AutoStopTimeConfig valueOf(String r100) {
        return (AutoStopTimeConfig) r27.a.a(AutoStopTimeConfig.class, r100);
    }

    public AutoStopTimeConfig(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
