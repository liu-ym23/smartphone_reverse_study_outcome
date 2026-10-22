package com.bytedance.ee.bear.bitable.toast;

import com.bytedance.ee.util.io.NonProguard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0003 !\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0016\n\u0002\u0010\u0011\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toast/ToastModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "type", "", "getType$annotations", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "content", "getContent", "setContent", "confirmText", "getConfirmText", "setConfirmText", "duration", "", "getDuration", "()Ljava/lang/Long;", "setDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "toString", "Companion", "ToastType", "CLoseType", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToastModel implements NonProguard {
    public static final a Companion = null;
    public static final long DEFAULT_DURATION = 3000;
    private String confirmText;
    private String content;
    private Long duration;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f215973id;
    private Integer type;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toast/ToastModel$CLoseType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Timeout", "Confirm", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CLoseType extends Enum<CLoseType> {
        public static final CLoseType Confirm = null;
        public static final CLoseType Timeout = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CLoseType[] f215974a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f215975b = null;
        private final int value;

        public static EnumEntries<CLoseType> getEntries() {
            return f215975b;
        }

        static {
            CLoseType r100 = new CLoseType("Timeout", 0, 0);
            Timeout = r100;
            CLoseType r101 = new CLoseType("Confirm", 1, 1);
            Confirm = r101;
            CLoseType[] r102 = {r100, r101};
            f215974a = r102;
            f215975b = EnumEntriesKt.enumEntries(r102);
        }

        public static CLoseType[] values() {
            return (CLoseType[]) f215974a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static CLoseType valueOf(String r100) {
            return (CLoseType) r27.a.a(CLoseType.class, r100);
        }

        public CLoseType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0081\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toast/ToastModel$ToastType;", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ToastType {
        public static final a Companion = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f215976a = null;

            public a() {
            }

            static {
                f215976a = new a();
                ToastTypeEnum.NORMAL.ordinal();
                ToastTypeEnum.LOADING.ordinal();
                ToastTypeEnum.FAIL.ordinal();
                ToastTypeEnum.SUCCESS.ordinal();
            }
        }

        static {
            Companion = a.f215976a;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ void getType$annotations() {
    }

    public String toString() {
        return "ToastModel(id=" + this.f215973id + ", type=" + this.type + ", content='" + this.content + "', confirmText=" + this.confirmText + ", duration=" + this.duration + ')';
    }

    public ToastModel() {
        this.duration = 3000L;
    }

    public final String getConfirmText() {
        return this.confirmText;
    }

    public final String getContent() {
        return this.content;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final String getId() {
        return this.f215973id;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setConfirmText(String r100) {
        this.confirmText = r100;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setDuration(Long r100) {
        this.duration = r100;
    }

    public final void setId(String r100) {
        this.f215973id = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }
}
