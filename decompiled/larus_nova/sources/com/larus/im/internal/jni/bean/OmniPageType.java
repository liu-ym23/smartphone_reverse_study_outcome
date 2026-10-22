package com.larus.im.internal.jni.bean;

import com.larus.im.internal.delegate.d1;
import de9.p9;
import java.lang.annotation.Annotation;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import nuc.i0;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniPageType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "PageType_UNKNOWN", "PageType_CHAT", "PageType_IMG_TMPL", "PageType_VIDEO", "PageType_MusicTmpl", "PageType_Feed_v2", "PageType_AI_Creation", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum OmniPageType extends Enum<OmniPageType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniPageType[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final Companion Companion = null;

    @SerialName("6")
    public static final OmniPageType PageType_AI_Creation = null;

    @SerialName("1")
    public static final OmniPageType PageType_CHAT = null;

    @SerialName("5")
    public static final OmniPageType PageType_Feed_v2 = null;

    @SerialName("2")
    public static final OmniPageType PageType_IMG_TMPL = null;

    @SerialName("4")
    public static final OmniPageType PageType_MusicTmpl = null;

    @SerialName("0")
    public static final OmniPageType PageType_UNKNOWN = null;

    @SerialName("3")
    public static final OmniPageType PageType_VIDEO = null;
    public final int value;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniPageType$Companion;", "", "<init>", "()V", "findByValue", "Lcom/larus/im/internal/jni/bean/OmniPageType;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final /* synthetic */ d get$cachedSerializer() {
            return (d) OmniPageType.access$get$cachedSerializer$delegate$cp().getValue();
        }

        public final d<OmniPageType> serializer() {
            return get$cachedSerializer();
        }

        @JvmStatic
        public final OmniPageType findByValue(int r100) {
            switch(r100) {
                case 0: goto L11;
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                default: goto L3;
            };
        L3:
            d1.f348206b.b("enum", "OmniPageType unknown value: " + r100);
            return OmniPageType.PageType_UNKNOWN;
        L13:
            return OmniPageType.PageType_AI_Creation;
        L14:
            return OmniPageType.PageType_Feed_v2;
        L15:
            return OmniPageType.PageType_MusicTmpl;
        L16:
            return OmniPageType.PageType_VIDEO;
        L17:
            return OmniPageType.PageType_IMG_TMPL;
        L18:
            return OmniPageType.PageType_CHAT;
        L11:
            return OmniPageType.PageType_UNKNOWN;
        }
    }

    private static final /* synthetic */ OmniPageType[] $values() {
        return new OmniPageType[]{PageType_UNKNOWN, PageType_CHAT, PageType_IMG_TMPL, PageType_VIDEO, PageType_MusicTmpl, PageType_Feed_v2, PageType_AI_Creation};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    @JvmStatic
    public static final OmniPageType findByValue(int r100) {
        return Companion.findByValue(r100);
    }

    public static EnumEntries<OmniPageType> getEntries() {
        return $ENTRIES;
    }

    static {
        PageType_UNKNOWN = new OmniPageType("PageType_UNKNOWN", 0, 0);
        PageType_CHAT = new OmniPageType("PageType_CHAT", 1, 1);
        PageType_IMG_TMPL = new OmniPageType("PageType_IMG_TMPL", 2, 2);
        PageType_VIDEO = new OmniPageType("PageType_VIDEO", 3, 3);
        PageType_MusicTmpl = new OmniPageType("PageType_MusicTmpl", 4, 4);
        PageType_Feed_v2 = new OmniPageType("PageType_Feed_v2", 5, 5);
        PageType_AI_Creation = new OmniPageType("PageType_AI_Creation", 6, 6);
        OmniPageType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new p9());
    }

    public static OmniPageType[] values() {
        return (OmniPageType[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.jni.bean.OmniPageType", values(), new String[]{"0", "1", "2", "3", "4", "5", "6"}, new Annotation[][]{null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static OmniPageType valueOf(String r100) {
        return (OmniPageType) a.a(OmniPageType.class, r100);
    }

    private OmniPageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
