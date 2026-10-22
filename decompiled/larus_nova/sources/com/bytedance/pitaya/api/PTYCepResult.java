package com.bytedance.pitaya.api;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/pitaya/api/PTYCepResult;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "builder", "Lcom/bytedance/pitaya/api/PTYCepResult$Builder;", "(Lcom/bytedance/pitaya/api/PTYCepResult$Builder;)V", "bizName", "", "getBizName", "()Ljava/lang/String;", "errorMessage", "getErrorMessage", "extraSequences", "", "Lorg/json/JSONObject;", "getExtraSequences", "()Ljava/util/List;", "matchedEventsSequences", "Lorg/json/JSONArray;", "getMatchedEventsSequences", "ruleName", "getRuleName", "success", "", "getSuccess", "()Z", "warnings", "getWarnings", "Builder", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PTYCepResult implements ReflectionCall {
    private final String bizName;
    private final String errorMessage;
    private final List<JSONObject> extraSequences;
    private final List<JSONArray> matchedEventsSequences;
    private final String ruleName;
    private final boolean success;
    private final String warnings;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010 J\u0006\u0010#\u001a\u00020$R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001a\u0010\u001a\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b¨\u0006%"}, d2 = {"Lcom/bytedance/pitaya/api/PTYCepResult$Builder;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "()V", "bizName", "", "getBizName", "()Ljava/lang/String;", "setBizName", "(Ljava/lang/String;)V", "errorMessage", "getErrorMessage", "setErrorMessage", "extraSequences", "Ljava/util/LinkedList;", "Lorg/json/JSONObject;", "getExtraSequences", "()Ljava/util/LinkedList;", "setExtraSequences", "(Ljava/util/LinkedList;)V", "matchedEventsSequences", "Lorg/json/JSONArray;", "getMatchedEventsSequences", "setMatchedEventsSequences", "ruleName", "getRuleName", "setRuleName", "warnings", "getWarnings", "setWarnings", "addExtra", "", "extra", "", "addSequence", "matchedEvents", "build", "Lcom/bytedance/pitaya/api/PTYCepResult;", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder implements ReflectionCall {
        private String bizName;
        private String errorMessage;
        private LinkedList<JSONObject> extraSequences;
        private LinkedList<JSONArray> matchedEventsSequences;
        private String ruleName;
        private String warnings;

        public final PTYCepResult build() {
            return new PTYCepResult(this, null);
        }

        public Builder() {
            this.bizName = "";
            this.ruleName = "";
            this.warnings = "";
            this.errorMessage = "";
            this.matchedEventsSequences = new LinkedList();
            this.extraSequences = new LinkedList();
        }

        public final String getBizName() {
            return this.bizName;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final LinkedList<JSONObject> getExtraSequences() {
            return this.extraSequences;
        }

        public final LinkedList<JSONArray> getMatchedEventsSequences() {
            return this.matchedEventsSequences;
        }

        public final String getRuleName() {
            return this.ruleName;
        }

        public final String getWarnings() {
            return this.warnings;
        }

        public final void addExtra(Object r100) {
            if ((r100 instanceof JSONObject) == false) goto L9;
            this.extraSequences.add(r100);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        public final void addSequence(Object r100) {
            if ((r100 instanceof JSONArray) == false) goto L6;
            this.matchedEventsSequences.add(r100);
            return;
        }

        public final void setBizName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.bizName = r100;
        }

        public final void setErrorMessage(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.errorMessage = r100;
        }

        public final void setExtraSequences(LinkedList<JSONObject> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.extraSequences = r100;
        }

        public final void setMatchedEventsSequences(LinkedList<JSONArray> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.matchedEventsSequences = r100;
        }

        public final void setRuleName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.ruleName = r100;
        }

        public final void setWarnings(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.warnings = r100;
        }
    }

    public /* synthetic */ PTYCepResult(Builder r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public final String getBizName() {
        return this.bizName;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final List<JSONObject> getExtraSequences() {
        return this.extraSequences;
    }

    public final List<JSONArray> getMatchedEventsSequences() {
        return this.matchedEventsSequences;
    }

    public final String getRuleName() {
        return this.ruleName;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getWarnings() {
        return this.warnings;
    }

    private PTYCepResult(Builder r100) {
        this.bizName = r100.getBizName();
        this.ruleName = r100.getRuleName();
        this.warnings = r100.getWarnings();
        this.errorMessage = r100.getErrorMessage();
        LinkedList<JSONArray> r101 = r100.getMatchedEventsSequences();
        this.matchedEventsSequences = r101;
        this.extraSequences = r100.getExtraSequences();
        this.success = !r101.isEmpty();
    }
}
