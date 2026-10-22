package com.bytedance.ee.bear.bitable.ddui;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/ddui/DDUIModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "action", "", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "componentType", "getComponentType", "setComponentType", WsConstants.KEY_PAYLOAD, "getPayload", "setPayload", "onUnmounted", "getOnUnmounted", "setOnUnmounted", "srcObjToken", "getSrcObjToken", "setSrcObjToken", "srcObjType", "", "getSrcObjType", "()Ljava/lang/Integer;", "setSrcObjType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ComponentType", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DDUIModel implements NonProguard {
    private String action;
    private String componentType;
    private String onUnmounted;
    private String payload;
    private String srcObjToken;
    private Integer srcObjType;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/ddui/DDUIModel$ComponentType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FILTER_PANEL", "FILTER_CONJUNCTION_PANEL", "FILTER_STEP_PANEL", "FILTER_LARK_FORM_FIELD_VISIBILITY_PANEL", "COLOR_PANEL", "RATING_PANEL", "FORMS_SHARE_PANEL", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ComponentType extends Enum<ComponentType> {
        public static final ComponentType COLOR_PANEL = null;
        public static final a Companion = null;
        public static final ComponentType FILTER_CONJUNCTION_PANEL = null;
        public static final ComponentType FILTER_LARK_FORM_FIELD_VISIBILITY_PANEL = null;
        public static final ComponentType FILTER_PANEL = null;
        public static final ComponentType FILTER_STEP_PANEL = null;
        public static final ComponentType FORMS_SHARE_PANEL = null;
        public static final ComponentType RATING_PANEL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ComponentType[] f211069a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f211070b = null;
        private final String value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<ComponentType> getEntries() {
            return f211070b;
        }

        static {
            ComponentType r100 = new ComponentType("FILTER_PANEL", 0, "filter");
            FILTER_PANEL = r100;
            ComponentType r101 = new ComponentType("FILTER_CONJUNCTION_PANEL", 1, "filterConjunctionPanel");
            FILTER_CONJUNCTION_PANEL = r101;
            ComponentType r102 = new ComponentType("FILTER_STEP_PANEL", 2, "filterStepPanel");
            FILTER_STEP_PANEL = r102;
            ComponentType r103 = new ComponentType("FILTER_LARK_FORM_FIELD_VISIBILITY_PANEL", 3, "filterLarkFormFieldVisibilityPanel");
            FILTER_LARK_FORM_FIELD_VISIBILITY_PANEL = r103;
            ComponentType r104 = new ComponentType("COLOR_PANEL", 4, "colorPanel");
            COLOR_PANEL = r104;
            ComponentType r105 = new ComponentType("RATING_PANEL", 5, "ratingPanel");
            RATING_PANEL = r105;
            ComponentType r110 = new ComponentType("FORMS_SHARE_PANEL", 6, "formsSharePanel");
            FORMS_SHARE_PANEL = r110;
            ComponentType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
            f211069a = r111;
            f211070b = EnumEntriesKt.enumEntries(r111);
            Companion = new a();
        }

        public static ComponentType[] values() {
            return (ComponentType[]) f211069a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static ComponentType valueOf(String r100) {
            return (ComponentType) r27.a.a(ComponentType.class, r100);
        }

        public ComponentType(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public DDUIModel() {
        this.action = "";
        this.componentType = "";
        this.onUnmounted = "";
    }

    public final String getAction() {
        return this.action;
    }

    public final String getComponentType() {
        return this.componentType;
    }

    public final String getOnUnmounted() {
        return this.onUnmounted;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final String getSrcObjToken() {
        return this.srcObjToken;
    }

    public final Integer getSrcObjType() {
        return this.srcObjType;
    }

    public final void setAction(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.action = r100;
    }

    public final void setComponentType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.componentType = r100;
    }

    public final void setOnUnmounted(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.onUnmounted = r100;
    }

    public final void setPayload(String r100) {
        this.payload = r100;
    }

    public final void setSrcObjToken(String r100) {
        this.srcObjToken = r100;
    }

    public final void setSrcObjType(Integer r100) {
        this.srcObjType = r100;
    }
}
