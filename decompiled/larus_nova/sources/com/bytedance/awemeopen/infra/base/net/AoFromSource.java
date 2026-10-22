package com.bytedance.awemeopen.infra.base.net;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0087\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;", "", "from", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "default", "upload", "download", "settings", "event", EffectConstants.CHANNEL_TEST, "Companion", "ao_base_core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum AoFromSource extends Enum<AoFromSource> {
    private static final /* synthetic */ AoFromSource[] $VALUES = null;
    public static final Companion Companion = null;

    /* JADX INFO: renamed from: default, reason: not valid java name */
    public static final AoFromSource f98default = null;
    public static final AoFromSource download = null;
    public static final AoFromSource event = null;
    public static final AoFromSource settings = null;
    public static final AoFromSource test = null;
    public static final AoFromSource upload = null;
    private final String from;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/net/AoFromSource$Companion;", "", "()V", "from", "Lcom/bytedance/awemeopen/infra/base/net/AoFromSource;", "name", "", "ao_base_core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final AoFromSource from(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            AoFromSource[] r101 = AoFromSource.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            AoFromSource r104 = r101[r103];
            if (StringsKt.equals(r104.getFrom(), r100, true) == true) goto L12;
            r103 = r103 + 1;
            goto L3
        L12:
            return r104;
        L8:
            return null;
        }
    }

    private static final /* synthetic */ AoFromSource[] $values() {
        return new AoFromSource[]{f98default, upload, download, settings, event, test};
    }

    @JvmStatic
    public static final AoFromSource from(String r100) {
        return Companion.from(r100);
    }

    public static AoFromSource valueOf(String r100) {
        return (AoFromSource) r27.a.a(AoFromSource.class, r100);
    }

    public static AoFromSource[] values() {
        return (AoFromSource[]) $VALUES.clone();
    }

    static {
        f98default = new AoFromSource("default", 0, "unknown");
        upload = new AoFromSource("upload", 1, "upload");
        download = new AoFromSource("download", 2, "download");
        settings = new AoFromSource("settings", 3, "settings");
        event = new AoFromSource("event", 4, "event");
        test = new AoFromSource(EffectConstants.CHANNEL_TEST, 5, EffectConstants.CHANNEL_TEST);
        $VALUES = $values();
        Companion = new Companion(null);
    }

    public final String getFrom() {
        return this.from;
    }

    private AoFromSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.from = r102;
    }
}
