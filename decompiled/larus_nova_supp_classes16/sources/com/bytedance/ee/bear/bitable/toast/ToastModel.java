package com.bytedance.ee.bear.bitable.toast;

import com.bytedance.ee.util.io.NonProguard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0003 !\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0016\n\u0002\u0010\u0011\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toast/ToastModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "type", "", "getType$annotations", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "content", "getContent", "setContent", "confirmText", "getConfirmText", "setConfirmText", "duration", "", "getDuration", "()Ljava/lang/Long;", "setDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "toString", "Companion", "ToastType", "CLoseType", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToastModel implements NonProguard {
    public static final a Companion = null;
    public static final long DEFAULT_DURATION = 3000;
    private String confirmText;
    private String content;
    private Long duration;
    private String id;
    private Integer type;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toast/ToastModel$CLoseType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Timeout", "Confirm", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CLoseType extends Enum<CLoseType> {
        public static final CLoseType Confirm = null;
        public static final CLoseType Timeout = null;
        public static final /* synthetic */ CLoseType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<CLoseType> getEntries() {
            return b;
        }

        static {
            CLoseType r0 = new CLoseType("Timeout", 0, 0);
            Timeout = r0;
            CLoseType r1 = new CLoseType("Confirm", 1, 1);
            Confirm = r1;
            CLoseType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static CLoseType[] values() {
            return (CLoseType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static CLoseType valueOf(String r1) {
            return (CLoseType) r27.a.a(CLoseType.class, r1);
        }

        public CLoseType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0081\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toast/ToastModel$ToastType;", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ToastType {
        public static final a Companion = null;

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
                ToastTypeEnum.NORMAL.ordinal();
                ToastTypeEnum.LOADING.ordinal();
                ToastTypeEnum.FAIL.ordinal();
                ToastTypeEnum.SUCCESS.ordinal();
            }
        }

        static {
            Companion = a.a;
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
        return "ToastModel(id=" + this.id + ", type=" + this.type + ", content='" + this.content + "', confirmText=" + this.confirmText + ", duration=" + this.duration + ')';
    }

    public ToastModel() {
        this.duration = Long.valueOf(DEFAULT_DURATION);
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
        return this.id;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setConfirmText(String r1) {
        this.confirmText = r1;
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public final void setDuration(Long r1) {
        this.duration = r1;
    }

    public final void setId(String r1) {
        this.id = r1;
    }

    public final void setType(Integer r1) {
        this.type = r1;
    }
}
