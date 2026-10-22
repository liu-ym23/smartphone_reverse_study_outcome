package com.ss.android.lark.export.entity.preview;

import com.alipay.sdk.m.p.e;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001'BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\"\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020\nH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006("}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UrlPreviewAction;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "url", "", e.f25671s, "Lcom/ss/android/lark/export/entity/preview/UrlPreviewAction$Method;", "parameters", "Lcom/ss/android/lark/export/entity/preview/Parameters;", "command", "", RuleConditionBean.OPEN_URL_KEY, "Lcom/ss/android/lark/export/entity/preview/Url;", "fallbackActionId", "action", "Lcom/ss/android/lark/export/entity/preview/BaseAction;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/UrlPreviewAction$Method;Lcom/ss/android/lark/export/entity/preview/Parameters;ILcom/ss/android/lark/export/entity/preview/Url;Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/BaseAction;)V", "getUrl", "()Ljava/lang/String;", "getMethod", "()Lcom/ss/android/lark/export/entity/preview/UrlPreviewAction$Method;", "getParameters", "()Lcom/ss/android/lark/export/entity/preview/Parameters;", "getCommand", "()I", "getOpenUrl", "()Lcom/ss/android/lark/export/entity/preview/Url;", "getFallbackActionId", "getAction", "()Lcom/ss/android/lark/export/entity/preview/BaseAction;", "isItemSame", "", "diffable", "isContentSame", "equals", "other", "", "hashCode", "Method", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlPreviewAction implements Serializable, b<UrlPreviewAction> {
    private final BaseAction action;
    private final int command;
    private final String fallbackActionId;
    private final Method method;
    private final Url openUrl;
    private final Parameters parameters;
    private final String url;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UrlPreviewAction$Method;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "UNKNOWN_METHOD", "GET", "POST", "LARK_COMMAND", "OPEN_URL", "SWITCH_STATE", "SHOW_TOAST", "SHOW_DIALOG", "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Method extends Enum<Method> implements Serializable {
        public static final a Companion = null;
        public static final Method GET = null;
        public static final Method LARK_COMMAND = null;
        public static final Method OPEN_URL = null;
        public static final Method POST = null;
        public static final Method SHOW_DIALOG = null;
        public static final Method SHOW_TOAST = null;
        public static final Method SWITCH_STATE = null;
        public static final Method UNKNOWN_METHOD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Method[] f420673a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f420674b = null;
        private int value;

        public static final class a {
            public a() {
            }

            public static Method a(int r100) {
                switch(r100) {
                    case 0: goto L12;
                    case 1: goto L20;
                    case 2: goto L19;
                    case 3: goto L18;
                    case 4: goto L17;
                    case 5: goto L16;
                    case 6: goto L15;
                    case 7: goto L14;
                    default: goto L13;
                };
            L13:
                return Method.UNKNOWN_METHOD;
            L14:
                return Method.SHOW_DIALOG;
            L15:
                return Method.SHOW_TOAST;
            L16:
                return Method.SWITCH_STATE;
            L17:
                return Method.OPEN_URL;
            L18:
                return Method.LARK_COMMAND;
            L19:
                return Method.POST;
            L20:
                return Method.GET;
            L12:
                return Method.UNKNOWN_METHOD;
            }
        }

        public static EnumEntries<Method> getEntries() {
            return f420674b;
        }

        static {
            Method r100 = new Method("UNKNOWN_METHOD", 0, 0);
            UNKNOWN_METHOD = r100;
            Method r101 = new Method("GET", 1, 1);
            GET = r101;
            Method r102 = new Method("POST", 2, 2);
            POST = r102;
            Method r103 = new Method("LARK_COMMAND", 3, 3);
            LARK_COMMAND = r103;
            Method r104 = new Method("OPEN_URL", 4, 4);
            OPEN_URL = r104;
            Method r105 = new Method("SWITCH_STATE", 5, 5);
            SWITCH_STATE = r105;
            Method r110 = new Method("SHOW_TOAST", 6, 6);
            SHOW_TOAST = r110;
            Method r111 = new Method("SHOW_DIALOG", 7, 7);
            SHOW_DIALOG = r111;
            Method[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
            f420673a = r112;
            f420674b = EnumEntriesKt.enumEntries(r112);
            Companion = new a();
        }

        public static Method[] values() {
            return (Method[]) f420673a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public static Method valueOf(String r100) {
            return (Method) r27.a.a(Method.class, r100);
        }

        public final void setValue(int r100) {
            this.value = r100;
        }

        public Method(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public int hashCode() {
        int r100 = ((this.url.hashCode() * 31) + this.method.hashCode()) * 31;
        Parameters r101 = this.parameters;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (((r100 + r103) * 31) + this.command) * 31;
        Url r105 = this.openUrl;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.fallbackActionId;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        BaseAction r111 = this.action;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        return r110 + r102;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final BaseAction getAction() {
        return this.action;
    }

    public final int getCommand() {
        return this.command;
    }

    public final String getFallbackActionId() {
        return this.fallbackActionId;
    }

    public final Method getMethod() {
        return this.method;
    }

    public final Url getOpenUrl() {
        return this.openUrl;
    }

    public final Parameters getParameters() {
        return this.parameters;
    }

    public final String getUrl() {
        return this.url;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UrlPreviewAction) == true) goto L8;
        return false;
    L8:
        UrlPreviewAction r101 = (UrlPreviewAction) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (this.method == r101.method) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.parameters, r101.parameters) == true) goto L18;
        return false;
    L18:
        if (this.command == r101.command) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.openUrl, r101.openUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.fallbackActionId, r101.fallbackActionId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public boolean isContentSame(UrlPreviewAction r100) {
        if (equals(r100) == false) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean isItemSame(UrlPreviewAction r100) {
        String r101 = this.url;
        if (r100 == null) goto L5;
        String r102 = r100.url;
    L7:
        if (Intrinsics.areEqual(r101, r102) == false) goto L10;
        return true;
    L10:
        return false;
    L5:
        r102 = null;
        goto L7
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((UrlPreviewAction) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((UrlPreviewAction) r100);
    }

    public UrlPreviewAction(String r100, Method r101, Parameters r102, int r103, Url r104, String r105, BaseAction r106) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        this.url = r100;
        this.method = r101;
        this.parameters = r102;
        this.command = r103;
        this.openUrl = r104;
        this.fallbackActionId = r105;
        this.action = r106;
    }
}
