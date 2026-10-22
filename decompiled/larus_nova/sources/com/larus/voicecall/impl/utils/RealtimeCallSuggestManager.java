package com.larus.voicecall.impl.utils;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaHideAssistData;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.io.Serializable;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes32.dex */
public final class RealtimeCallSuggestManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f379495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e3a.a f379496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.voicecall.impl.component.scene.a f379497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f379498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f379499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function3<? super List<String>, ? super String, ? super Continuation<? super Unit>, ? extends Object> f379500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f379501g;

    public static final class Repository {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e3a.a f379502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.larus.voicecall.impl.component.scene.a f379503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f379504c;

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ,\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/larus/voicecall/impl/utils/RealtimeCallSuggestManager$Repository$SuggestionData;", "Ljava/io/Serializable;", "suggestList", "", "", "inExperiment", "", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;)V", "getSuggestList", "()Ljava/util/List;", "getInExperiment", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Boolean;)Lcom/larus/voicecall/impl/utils/RealtimeCallSuggestManager$Repository$SuggestionData;", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class SuggestionData implements Serializable {

            @SerializedName("hit_suggest")
            private final Boolean inExperiment;

            @SerializedName(FormulaHideAssistData.TARGET_SUGGESTIONS)
            @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
            private final List<String> suggestList;

            /* JADX WARN: Multi-variable type inference failed */
            public SuggestionData() {
                Object[] r100 = 0 == true ? 1 : 0;
                this(null, r100, 3, 0 == true ? 1 : 0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SuggestionData copy$default(SuggestionData r100, List r101, Boolean r102, int r103, Object r104) {
                if ((r103 & 1) == 0) goto L6;
                r101 = r100.suggestList;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r102 = r100.inExperiment;
            L9:
                return r100.copy(r101, r102);
            }

            public final List<String> component1() {
                return this.suggestList;
            }

            public final Boolean component2() {
                return this.inExperiment;
            }

            public final SuggestionData copy(List<String> r100, Boolean r101) {
                return new SuggestionData(r100, r101);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof SuggestionData) == true) goto L8;
                return false;
            L8:
                SuggestionData r101 = (SuggestionData) r100;
                if (Intrinsics.areEqual(this.suggestList, r101.suggestList) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.inExperiment, r101.inExperiment) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                List<String> r100 = this.suggestList;
                int r101 = 0;
                if (r100 != null) goto L5;
                int r102 = 0;
            L6:
                int r103 = r102 * 31;
                Boolean r104 = this.inExperiment;
                if (r104 == null) goto L11;
                r101 = r104.hashCode();
            L11:
                return r103 + r101;
            L5:
                r102 = r100.hashCode();
                goto L6
            }

            public String toString() {
                return "SuggestionData(suggestList=" + this.suggestList + ", inExperiment=" + this.inExperiment + ')';
            }

            public final Boolean getInExperiment() {
                return this.inExperiment;
            }

            public final List<String> getSuggestList() {
                return this.suggestList;
            }

            public SuggestionData(List<String> r100, Boolean r101) {
                this.suggestList = r100;
                this.inExperiment = r101;
            }

            public /* synthetic */ SuggestionData(List r100, Boolean r101, int r102, DefaultConstructorMarker r103) {
                if ((r102 & 1) == 0) goto L6;
                r100 = CollectionsKt.emptyList();
            L6:
                if ((r102 & 2) == 0) goto L8;
                r101 = null;
            L8:
                this(r100, r101);
            }
        }

        public static final class a {
        }

        static {
        }

        public final Object a(Continuation<? super List<String>> r100) {
            if ((r100 instanceof RealtimeCallSuggestManager$Repository$getSuggestList$1) == false) goto L7;
            RealtimeCallSuggestManager$Repository$getSuggestList$1 r101 = (RealtimeCallSuggestManager$Repository$getSuggestList$1) r100;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            Object r103 = r101.result;
            Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r105 = r101.label;
            if (r105 == 0) goto L14;
            if (r105 != 1) goto L13;
            ResultKt.throwOnFailure(r103);
        L21:
            SuggestionData r106 = (SuggestionData) r103;
            if (r106 != null) goto L26;
            return CollectionsKt.emptyList();
        L26:
            if (r106.getInExperiment() == null) goto L28;
            this.f379504c = r106.getInExperiment().booleanValue();
        L28:
            List<String> r107 = r106.getSuggestList();
            if (r107 == null) goto L31;
            return r107;
        L31:
            return CollectionsKt.emptyList();
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r103);
            if (this.f379504c == false) goto L17;
            CoroutineDispatcher r108 = Dispatchers.getIO();
            RealtimeCallSuggestManager$Repository$getSuggestList$response$1 r109 = new RealtimeCallSuggestManager$Repository$getSuggestList$response$1(this, null);
            r101.label = 1;
            r103 = BuildersKt.withContext(r108, r109, r101);
            if (r103 != r104) goto L21;
            return r104;
        L17:
            return CollectionsKt.emptyList();
        L7:
            r101 = new RealtimeCallSuggestManager$Repository$getSuggestList$1(this, r100);
            goto L8
        }

        public Repository(e3a.a r100, com.larus.voicecall.impl.component.scene.a r101) {
            Intrinsics.checkNotNullParameter(r100, "argument");
            this.f379502a = r100;
            this.f379503b = r101;
            this.f379504c = true;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/voicecall/impl/utils/RealtimeCallSuggestManager$ShowFrom;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CALL_DIRECT", "CALL_SILENCE_POPUP", "RECONNECTION", "CHOOSE_CALL_SCENE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ShowFrom extends Enum<ShowFrom> {
        public static final ShowFrom CALL_DIRECT = null;
        public static final ShowFrom CALL_SILENCE_POPUP = null;
        public static final ShowFrom CHOOSE_CALL_SCENE = null;
        public static final ShowFrom RECONNECTION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ShowFrom[] f379505a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f379506b = null;
        private final String value;

        public static EnumEntries<ShowFrom> getEntries() {
            return f379506b;
        }

        static {
            ShowFrom r100 = new ShowFrom("CALL_DIRECT", 0, "call_direct");
            CALL_DIRECT = r100;
            ShowFrom r101 = new ShowFrom("CALL_SILENCE_POPUP", 1, "call_silence_popup");
            CALL_SILENCE_POPUP = r101;
            ShowFrom r102 = new ShowFrom("RECONNECTION", 2, "reconnection");
            RECONNECTION = r102;
            ShowFrom r103 = new ShowFrom("CHOOSE_CALL_SCENE", 3, "choose_call_scene");
            CHOOSE_CALL_SCENE = r103;
            ShowFrom[] r104 = {r100, r101, r102, r103};
            f379505a = r104;
            f379506b = EnumEntriesKt.enumEntries(r104);
        }

        public static ShowFrom[] values() {
            return (ShowFrom[]) f379505a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static ShowFrom valueOf(String r100) {
            return (ShowFrom) r27.a.a(ShowFrom.class, r100);
        }

        public ShowFrom(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Timer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CoroutineScope f379507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function1<? super Continuation<? super Unit>, ? extends Object> f379508b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Lazy f379509c;

        public Timer(CoroutineScope r100, final long r101) {
            Intrinsics.checkNotNullParameter(r100, "scope");
            this.f379507a = r100;
            this.f379508b = new RealtimeCallSuggestManager$Timer$onTimerFinish$1(null);
            this.f379509c = LazyKt.lazy(new n(r101, this));
        }
    }

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f379511a;

        public a(o r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f379511a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f379511a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f379511a.invoke(r100);
        }
    }

    public RealtimeCallSuggestManager(LifecycleCoroutineScope r100, e3a.a r101, com.larus.voicecall.impl.component.scene.a r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "argument");
        this.f379495a = r100;
        this.f379496b = r101;
        this.f379497c = r102;
        this.f379498d = LazyKt.lazy(new l(this));
        this.f379499e = LazyKt.lazy(new m(this));
        this.f379500f = new RealtimeCallSuggestManager$updateListener$1(null);
        this.f379501g = true;
    }
}
