package com.larus.platform.model.action;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\b\t\n\u000b\f\rB\u0013\b\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0006\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/platform/model/action/SuggestedActionOperation;", "", "type", "", "<init>", "(I)V", "getType", "()I", "InsertFirst", "InsertLast", "Remove", "Modify", "SetEventExtra", "SetMessageExt", "Lcom/larus/platform/model/action/SuggestedActionOperation$InsertFirst;", "Lcom/larus/platform/model/action/SuggestedActionOperation$InsertLast;", "Lcom/larus/platform/model/action/SuggestedActionOperation$Modify;", "Lcom/larus/platform/model/action/SuggestedActionOperation$Remove;", "Lcom/larus/platform/model/action/SuggestedActionOperation$SetEventExtra;", "Lcom/larus/platform/model/action/SuggestedActionOperation$SetMessageExt;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class a {

    @SerializedName("op_type")
    private final int type;

    /* JADX INFO: renamed from: com.larus.platform.model.action.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/platform/model/action/SuggestedActionOperation$InsertFirst;", "Lcom/larus/platform/model/action/SuggestedActionOperation;", "suggestedAction", "Lcom/larus/platform/model/action/SuggestedAction;", "deDuplicate", "", "<init>", "(Lcom/larus/platform/model/action/SuggestedAction;Z)V", "getSuggestedAction", "()Lcom/larus/platform/model/action/SuggestedAction;", "getDeDuplicate", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C4470a extends a {

        @SerializedName("de_dup")
        private final boolean deDuplicate;

        @SerializedName("action")
        private final SuggestedAction suggestedAction;

        public C4470a() {
            this(null, false);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4470a) == true) goto L8;
            return false;
        L8:
            C4470a r101 = (C4470a) r100;
            if (Intrinsics.areEqual(this.suggestedAction, r101.suggestedAction) == true) goto L12;
            return false;
        L12:
            if (this.deDuplicate == r101.deDuplicate) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            SuggestedAction r100 = this.suggestedAction;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            int r102 = r101 * 31;
            if (this.deDuplicate == false) goto L9;
            int r103 = 1231;
        L11:
            return r102 + r103;
        L9:
            r103 = 1237;
            goto L11
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "InsertFirst(suggestedAction=" + this.suggestedAction + ", deDuplicate=" + this.deDuplicate + ')';
        }

        public final boolean a() {
            return this.deDuplicate;
        }

        public final SuggestedAction b() {
            return this.suggestedAction;
        }

        public C4470a(SuggestedAction r100, boolean r101) {
            super(10);
            this.suggestedAction = r100;
            this.deDuplicate = r101;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/platform/model/action/SuggestedActionOperation$InsertLast;", "Lcom/larus/platform/model/action/SuggestedActionOperation;", "suggestedAction", "Lcom/larus/platform/model/action/SuggestedAction;", "deDuplicate", "", "<init>", "(Lcom/larus/platform/model/action/SuggestedAction;Z)V", "getSuggestedAction", "()Lcom/larus/platform/model/action/SuggestedAction;", "getDeDuplicate", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends a {

        @SerializedName("de_dup")
        private final boolean deDuplicate;

        @SerializedName("action")
        private final SuggestedAction suggestedAction;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.suggestedAction, r101.suggestedAction) == true) goto L12;
            return false;
        L12:
            if (this.deDuplicate == r101.deDuplicate) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            SuggestedAction r100 = this.suggestedAction;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            int r102 = r101 * 31;
            if (this.deDuplicate == false) goto L9;
            int r103 = 1231;
        L11:
            return r102 + r103;
        L9:
            r103 = 1237;
            goto L11
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "InsertLast(suggestedAction=" + this.suggestedAction + ", deDuplicate=" + this.deDuplicate + ')';
        }

        public b() {
            super(20);
            this.suggestedAction = null;
            this.deDuplicate = false;
        }

        public final boolean a() {
            return this.deDuplicate;
        }

        public final SuggestedAction b() {
            return this.suggestedAction;
        }
    }

    public static abstract class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient Function1<SuggestedAction, Boolean> f365502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final transient Function1<SuggestedAction, SuggestedAction> f365503b;

        /* JADX INFO: renamed from: com.larus.platform.model.action.a$c$a, reason: collision with other inner class name */
        public static final class C4471a extends c {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final C4471a f365504c = null;

            static {
                f365504c = new C4471a();
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [iq9.a] */
            /* JADX WARN: Type inference failed for: r1v0, types: [iq9.b] */
            public C4471a() {
                super(new iq9.a(), new iq9.b());
            }
        }

        public c() {
            throw null;
        }

        public c(iq9.a r100, iq9.b r101) {
            super(41);
            this.f365502a = r100;
            this.f365503b = r101;
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient Function1<SuggestedAction, Boolean> f365505a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f365505a, ((d) r100).f365505a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f365505a.hashCode();
        }

        public final String toString() {
            return "Remove(matcher=" + this.f365505a + ')';
        }

        public d() {
            Function1<SuggestedAction, Boolean> r100 = new iq9.c();
            Intrinsics.checkNotNullParameter(r100, "matcher");
            super(30);
            this.f365505a = r100;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\n\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/larus/platform/model/action/SuggestedActionOperation$SetEventExtra;", "Lcom/larus/platform/model/action/SuggestedActionOperation;", "eventExtra", "", "", "<init>", "(Ljava/util/Map;)V", "getEventExtra", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e extends a {

        @SerializedName("event_extra")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private final Map<String, String> eventExtra;

        public e() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.eventExtra, ((e) r100).eventExtra) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Map<String, String> r100 = this.eventExtra;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "SetEventExtra(eventExtra=" + this.eventExtra + ')';
        }

        public final Map<String, String> a() {
            return this.eventExtra;
        }

        public e(Map<String, String> r100) {
            super(50);
            this.eventExtra = r100;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\n\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/larus/platform/model/action/SuggestedActionOperation$SetMessageExt;", "Lcom/larus/platform/model/action/SuggestedActionOperation;", "msgExt", "", "", "<init>", "(Ljava/util/Map;)V", "getMsgExt", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f extends a {

        @SerializedName(ChatDraftItem.TYPE_MSG_EXT)
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private final Map<String, String> msgExt;

        public f() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.msgExt, ((f) r100).msgExt) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Map<String, String> r100 = this.msgExt;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "SetMessageExt(msgExt=" + this.msgExt + ')';
        }

        public final Map<String, String> a() {
            return this.msgExt;
        }

        public f(Map<String, String> r100) {
            super(60);
            this.msgExt = r100;
        }
    }

    public final int getType() {
        return this.type;
    }

    public a(int r100) {
        this.type = r100;
    }
}
