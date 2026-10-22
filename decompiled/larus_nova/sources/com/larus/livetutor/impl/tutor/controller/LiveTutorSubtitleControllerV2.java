package com.larus.livetutor.impl.tutor.controller;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelKt;
import com.larus.livetutor.api.idl.AudioExtraV2;
import com.larus.livetutor.api.idl.LiveTutorSubtitle;
import com.larus.livetutor.api.idl.SubtitleType;
import com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel;
import com.larus.livetutor.impl.utils.UtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes30.dex */
public final class LiveTutorSubtitleControllerV2 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f356456i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Job f356457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LiveTutorViewModel f356458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r0 f356459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Part> f356460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f356461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f356462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile Pos f356463g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f356464h;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0019\u001a\u00020\u0013J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J7\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/larus/livetutor/impl/tutor/controller/LiveTutorSubtitleControllerV2$Part;", "", "partId", "", "partInTutorIdx", "sentences", "", "Lcom/larus/livetutor/impl/tutor/controller/LiveTutorSubtitleControllerV2$Sentence;", "isAsr", "", "<init>", "(JJLjava/util/List;Z)V", "getPartId", "()J", "getPartInTutorIdx", "getSentences", "()Ljava/util/List;", "()Z", "value", "", "currentContent", "getCurrentContent", "()Ljava/lang/String;", "setCurrentContent$impl_mainlandRelease", "(Ljava/lang/String;)V", "wholeContent", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Part {
        private String currentContent;
        private final boolean isAsr;
        private final long partId;
        private final long partInTutorIdx;
        private final List<Sentence> sentences;

        public static /* synthetic */ CharSequence a(Sentence r100) {
            return wholeContent$lambda$0(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Part copy$default(Part r100, long r101, long r110, List r111, boolean r112, int r113, Object r114) {
            if ((r113 & 1) == 0) goto L5;
            r101 = r100.partId;
        L5:
            long r102 = r101;
            if ((r113 & 2) == 0) goto L8;
            r110 = r100.partInTutorIdx;
        L8:
            long r103 = r110;
            if ((r113 & 4) == 0) goto L11;
            r111 = r100.sentences;
        L11:
            List r104 = r111;
            if ((r113 & 8) == 0) goto L15;
            r112 = r100.isAsr;
        L15:
            return r100.copy(r102, r103, r104, r112);
        }

        public final long component1() {
            return this.partId;
        }

        public final long component2() {
            return this.partInTutorIdx;
        }

        public final List<Sentence> component3() {
            return this.sentences;
        }

        public final boolean component4() {
            return this.isAsr;
        }

        public final Part copy(long r100, long r110, List<Sentence> r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r111, "sentences");
            return new Part(r100, r110, r111, r112);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Part) == true) goto L8;
            return false;
        L8:
            Part r101 = (Part) r100;
            if (this.partId == r101.partId) goto L12;
            return false;
        L12:
            if (this.partInTutorIdx == r101.partInTutorIdx) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.sentences, r101.sentences) == true) goto L18;
            return false;
        L18:
            if (this.isAsr == r101.isAsr) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            long r100 = this.partId;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.partInTutorIdx;
            int r103 = (((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.sentences.hashCode()) * 31;
            if (this.isAsr == false) goto L5;
            int r104 = 1231;
        L7:
            return r103 + r104;
        L5:
            r104 = 1237;
            goto L7
        }

        public String toString() {
            return super.toString() + ", currentContent = " + this.currentContent;
        }

        public final String wholeContent() {
            return CollectionsKt.joinToString$default(this.sentences, "", null, null, 0, null, new l0(), 30, null);
        }

        public final String getCurrentContent() {
            return this.currentContent;
        }

        public final long getPartId() {
            return this.partId;
        }

        public final long getPartInTutorIdx() {
            return this.partInTutorIdx;
        }

        public final List<Sentence> getSentences() {
            return this.sentences;
        }

        public final boolean isAsr() {
            return this.isAsr;
        }

        private static final CharSequence wholeContent$lambda$0(Sentence r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return r100.getText();
        }

        public final void setCurrentContent$impl_mainlandRelease(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.currentContent = r100;
        }

        public Part(long r100, long r101, List<Sentence> r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r102, "sentences");
            this.partId = r100;
            this.partInTutorIdx = r101;
            this.sentences = r102;
            this.isAsr = r103;
            this.currentContent = "";
        }

        public /* synthetic */ Part(long r100, long r110, List r111, boolean r112, int r113, DefaultConstructorMarker r114) {
            if ((r113 & 8) == 0) goto L5;
            boolean r101 = false;
        L6:
            this(r100, r110, r111, r101);
            return;
        L5:
            r101 = r112;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0083\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/larus/livetutor/impl/tutor/controller/LiveTutorSubtitleControllerV2$Pos;", "", "partId", "", "parInTutorIdx", "sentenceIdx", "end", "", "ttsIdx", "<init>", "(JJJIJ)V", "getPartId", "()J", "getParInTutorIdx", "getSentenceIdx", "getEnd", "()I", "getTtsIdx", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Pos {
        private final int end;
        private final long parInTutorIdx;
        private final long partId;
        private final long sentenceIdx;
        private final long ttsIdx;

        public static /* synthetic */ Pos copy$default(Pos r110, long r111, long r112, long r113, int r114, long r115, int r210, Object r211) {
            if ((r210 & 1) == 0) goto L5;
            long r100 = r110.partId;
        L7:
            if ((r210 & 2) == 0) goto L9;
            long r101 = r110.parInTutorIdx;
        L11:
            if ((r210 & 4) == 0) goto L13;
            long r102 = r110.sentenceIdx;
        L15:
            if ((r210 & 8) == 0) goto L17;
            int r103 = r110.end;
        L19:
            if ((r210 & 16) == 0) goto L21;
            long r104 = r110.ttsIdx;
        L23:
            return r110.copy(r100, r101, r102, r103, r104);
        L21:
            r104 = r115;
            goto L23
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final long component1() {
            return this.partId;
        }

        public final long component2() {
            return this.parInTutorIdx;
        }

        public final long component3() {
            return this.sentenceIdx;
        }

        public final int component4() {
            return this.end;
        }

        public final long component5() {
            return this.ttsIdx;
        }

        public final Pos copy(long r110, long r111, long r112, int r113, long r114) {
            return new Pos(r110, r111, r112, r113, r114);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Pos) == true) goto L8;
            return false;
        L8:
            Pos r101 = (Pos) r100;
            if (this.partId == r101.partId) goto L12;
            return false;
        L12:
            if (this.parInTutorIdx == r101.parInTutorIdx) goto L15;
            return false;
        L15:
            if (this.sentenceIdx == r101.sentenceIdx) goto L18;
            return false;
        L18:
            if (this.end == r101.end) goto L21;
            return false;
        L21:
            if (this.ttsIdx == r101.ttsIdx) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            long r100 = this.partId;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.parInTutorIdx;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.sentenceIdx;
            int r105 = (((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.end) * 31;
            long r106 = this.ttsIdx;
            return r105 + ((int) (r106 ^ (r106 >>> 32)));
        }

        public String toString() {
            return "Pos(partId=" + this.partId + ", parInTutorIdx=" + this.parInTutorIdx + ", sentenceIdx=" + this.sentenceIdx + ", end=" + this.end + ", ttsIdx=" + this.ttsIdx + ')';
        }

        public final int getEnd() {
            return this.end;
        }

        public final long getParInTutorIdx() {
            return this.parInTutorIdx;
        }

        public final long getPartId() {
            return this.partId;
        }

        public final long getSentenceIdx() {
            return this.sentenceIdx;
        }

        public final long getTtsIdx() {
            return this.ttsIdx;
        }

        public Pos(long r100, long r101, long r102, int r103, long r104) {
            this.partId = r100;
            this.parInTutorIdx = r101;
            this.sentenceIdx = r102;
            this.end = r103;
            this.ttsIdx = r104;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/livetutor/impl/tutor/controller/LiveTutorSubtitleControllerV2$Sentence;", "", "sentenceIdx", "", "text", "", "<init>", "(JLjava/lang/String;)V", "getSentenceIdx", "()J", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Sentence {
        private final long sentenceIdx;
        private final String text;

        public static /* synthetic */ Sentence copy$default(Sentence r100, long r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.sentenceIdx;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.text;
        L9:
            return r100.copy(r101, r102);
        }

        public final long component1() {
            return this.sentenceIdx;
        }

        public final String component2() {
            return this.text;
        }

        public final Sentence copy(long r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "text");
            return new Sentence(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Sentence) == true) goto L8;
            return false;
        L8:
            Sentence r101 = (Sentence) r100;
            if (this.sentenceIdx == r101.sentenceIdx) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.text, r101.text) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            long r100 = this.sentenceIdx;
            return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.text.hashCode();
        }

        public String toString() {
            return "Sentence(sentenceIdx=" + this.sentenceIdx + ", text=" + this.text + ')';
        }

        public final long getSentenceIdx() {
            return this.sentenceIdx;
        }

        public final String getText() {
            return this.text;
        }

        public Sentence(long r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "text");
            this.sentenceIdx = r100;
            this.text = r101;
        }
    }

    public static final class a {
    }

    static {
    }

    public final Part b() {
        Part r100 = (Part) CollectionsKt.lastOrNull(this.f356460d);
        if (r100 != null) goto L5;
    L15:
        return null;
    L5:
        if ((!r100.isAsr()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L15;
        Sentence r101 = (Sentence) CollectionsKt.lastOrNull(r100.getSentences());
        if (r101 != null) goto L13;
        return null;
    L13:
        this.f356463g = new Pos(r100.getPartId(), r100.getPartInTutorIdx(), r101.getSentenceIdx(), r101.getText().length(), Long.MAX_VALUE);
        return r100;
    }

    public LiveTutorSubtitleControllerV2() {
        this.f356460d = new ArrayList();
        this.f356461e = -1;
        this.f356462f = -1;
    }

    public final void a(List<LiveTutorSubtitle> r100) {
        kj9.b.a("[LiveTutorSubtitleController] receive clear msg, clear subtitles");
        r0 r101 = this.f356459c;
        if (r101 == null) goto L5;
        r101.onClear();
    L5:
        Iterator<LiveTutorSubtitle> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L37;
        final LiveTutorSubtitle r103 = r102.next();
        if (r103.getSentenceIdx() == null) goto L10;
        Iterator r104 = ((ArrayList) this.f356460d).iterator();
    L13:
        if (r104.hasNext() == false) goto L23;
        Object r105 = r104.next();
        long r106 = ((Part) r105).getPartId();
        Long r107 = r103.getTutorPartId();
        if (r107 != null) goto L18;
    L20:
        boolean r108 = false;
    L21:
        if (r108 == false) goto L13;
    L24:
        Part r109 = (Part) r105;
        if (r109 == null) goto L7;
        List<Sentence> r110 = r109.getSentences();
        if (r110 == null) goto L7;
        Iterator<Sentence> r111 = r110.iterator();
    L30:
        if (r111.hasNext() == false) goto L7;
        long r112 = r111.next().getSentenceIdx();
        Long r113 = r103.getSentenceIdx();
        if (r113 == null) goto L30;
        if (r112 != r113.longValue()) goto L30;
        r111.remove();
        goto L30
    L18:
        if (r106 != r107.longValue()) goto L20;
        r108 = true;
        goto L21
    L23:
        r105 = null;
        goto L24
    L10:
        CollectionsKt.removeAll(this.f356460d, new i0(r103));
        goto L7
    }

    public final String c(AudioExtraV2 r100) {
        return "currentPartId = " + this.f356461e + ", audio partId = " + r100.getPartId() + "\ncurrentPartInTutorIdx = " + this.f356462f + ", audio partInTutorIdx = " + r100.getPartInTutorIdx() + "\naudio = " + r100;
    }

    public final String d(LiveTutorSubtitle r100) {
        return "currentPartId = " + this.f356461e + ", tutorPartId = " + r100.getTutorPartId() + "\ncurrentPartInTutorIdx = " + this.f356462f + ", audio partInTutorIdx = " + r100.getPartInTutorIdx() + "\nsubtitle = " + r100;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.larus.livetutor.impl.tutor.controller.k0] */
    public final void e(LiveTutorViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        this.f356458b = r100;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(r100), Dispatchers.getIO(), null, new LiveTutorSubtitleControllerV2$initObserver$1(r100, this, null), 2, null);
        this.f356457a = UtilsKt.n(ViewModelKt.getViewModelScope(r100), Dispatchers.getIO(), new LiveTutorSubtitleControllerV2$initObserver$2(r100, this, null), 2);
        r100.addClosePageListener(new j0(this));
        LifecycleOwner r101 = r100.getLifecycleOwner();
        if (r101 != null) goto L5;
        return;
    L5:
        r100.getPauseRtc().observe(r101, new m0.a(new k0()));
        UtilsKt.n(ViewModelKt.getViewModelScope(r100), Dispatchers.getIO(), new LiveTutorSubtitleControllerV2$initObserver$5(r100, this, null), 2);
    }

    public final void f(LiveTutorSubtitle r110) {
        boolean r100 = kj9.b.f503724a;
        kj9.b.a("[LiveTutorSubtitleController] insert asr content, subtitle = " + r110);
        List<Part> r101 = this.f356460d;
        Long r102 = r110.getTutorPartId();
        long r103 = 0;
        if (r102 == null) goto L5;
        long r104 = r102.longValue();
    L6:
        Sentence[] r105 = new Sentence[1];
        String r106 = r110.getTotalText();
        if (r106 != null) goto L9;
        r106 = "";
    L9:
        r105[0] = new Sentence(0, r106);
        List r111 = CollectionsKt.mutableListOf(r105);
        Long r112 = r110.getPartInTutorIdx();
        if (r112 == null) goto L12;
        r103 = r112.longValue();
    L12:
        Part r113 = new Part(r104, r103, r111, true);
        r113.setCurrentContent$impl_mainlandRelease(r113.wholeContent());
        ((ArrayList) r101).add(r113);
        return;
    L5:
        r104 = 0;
        goto L6
    }

    public final void g(LiveTutorSubtitle r110) {
        boolean r100 = kj9.b.f503724a;
        kj9.b.a("[LiveTutorSubtitleController] insert sentence, subtitle = " + r110);
        List<Part> r101 = this.f356460d;
        Long r102 = r110.getTutorPartId();
        Long r103 = r110.getPartInTutorIdx();
        ArrayList r104 = (ArrayList) r101;
        ListIterator r105 = r104.listIterator(r104.size());
    L4:
        if (r105.hasPrevious() == false) goto L14;
        Object r106 = r105.previous();
        long r107 = ((Part) r106).getPartId();
        if (r102 != null) goto L9;
    L11:
        boolean r108 = false;
    L12:
        if (r108 == false) goto L4;
    L15:
        Part r109 = (Part) r106;
        long r111 = 0;
        if (r109 == null) goto L18;
    L25:
        List<Sentence> r112 = r109.getSentences();
        Long r113 = r110.getSentenceIdx();
        if (r113 == null) goto L28;
        r111 = r113.longValue();
    L28:
        String r114 = r110.getTotalText();
        if (r114 != null) goto L31;
        r114 = "";
    L31:
        r112.add(new Sentence(r111, r114));
        return;
    L18:
        if (r102 == null) goto L20;
        long r115 = r102.longValue();
    L21:
        if (r103 == null) goto L23;
        long r116 = r103.longValue();
    L24:
        r109 = new Part(r115, r116, new ArrayList(), false, 8, null);
        r104.add(r109);
        goto L25
    L23:
        r116 = 0;
        goto L24
    L20:
        r115 = 0;
        goto L21
    L9:
        if (r107 != r102.longValue()) goto L11;
        r108 = true;
        goto L12
    L14:
        r106 = null;
        goto L15
    }

    public final void h(List<LiveTutorSubtitle> r110) {
        boolean r100 = kj9.b.f503724a;
        kj9.b.a("[LiveTutorSubtitleController] mergeHistoryPartData subtitleList = " + r110);
        ((ArrayList) this.f356460d).clear();
        Iterator<T> r111 = r110.iterator();
    L4:
        if (r111.hasNext() == false) goto L43;
        LiveTutorSubtitle r101 = (LiveTutorSubtitle) r111.next();
        long r102 = 0;
        if (((ArrayList) this.f356460d).isEmpty() == true) goto L12;
        Long r103 = r101.getTutorPartId();
        long r104 = this.f356461e;
        if (r103 == null) goto L12;
        if (r103.longValue() != r104) goto L12;
    L36:
        Part r105 = (Part) CollectionsKt.last(this.f356460d);
        List<Sentence> r106 = r105.getSentences();
        Long r107 = r101.getSentenceIdx();
        if (r107 == null) goto L39;
        r102 = r107.longValue();
    L39:
        String r108 = r101.getTotalText();
        if (r108 != null) goto L42;
        r108 = "";
    L42:
        r106.add(new Sentence(r102, r108));
        r105.setCurrentContent$impl_mainlandRelease(r105.wholeContent());
    L12:
        List<Part> r109 = this.f356460d;
        Long r112 = r101.getTutorPartId();
        if (r112 == null) goto L15;
        long r113 = r112.longValue();
    L16:
        ArrayList r114 = new ArrayList();
        Long r115 = r101.getPartInTutorIdx();
        if (r115 == null) goto L19;
        long r116 = r115.longValue();
    L20:
        Integer r117 = r101.getSubtitleType();
        int r118 = SubtitleType.Asr.getValue();
        if (r117 != null) goto L24;
    L26:
        boolean r119 = false;
    L27:
        ((ArrayList) r109).add(new Part(r113, r116, r114, r119));
        Long r120 = r101.getTutorPartId();
        if (r120 == null) goto L30;
        long r121 = r120.longValue();
    L31:
        this.f356461e = r121;
        Long r122 = r101.getPartInTutorIdx();
        if (r122 == null) goto L34;
        long r123 = r122.longValue();
    L35:
        this.f356462f = r123;
        goto L36
    L34:
        r123 = 0;
        goto L35
    L30:
        r121 = 0;
        goto L31
    L24:
        if (r117.intValue() != r118) goto L26;
        r119 = true;
        goto L27
    L19:
        r116 = 0;
        goto L20
    L15:
        r113 = 0;
        goto L16
    }

    public final void i(AudioExtraV2 r210) {
        if (r210.getPartId() == null) goto L26;
        Integer r100 = r210.getSentenceIdx();
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L26;
        Integer r102 = r210.getStartIdx();
        if (r102 != null) goto L14;
    L16:
        boolean r103 = false;
    L17:
        if (r103 == false) goto L26;
        Integer r104 = r210.getLen();
        if (r104 != null) goto L21;
    L23:
        boolean r105 = false;
    L24:
        if (r105 == false) goto L26;
        boolean r106 = true;
    L27:
        if (r106 == true) goto L30;
        boolean r107 = kj9.b.f503724a;
        kj9.b.b("[LiveTutorSubtitleController] audioExtra is invalid, audioExtra = " + r210);
        return;
    L30:
        long r108 = this.f356462f;
        Integer r109 = r210.getPartInTutorIdx();
        long r110 = 0;
        if (r109 == null) goto L33;
        long r111 = r109.intValue();
    L35:
        if (r108 <= r111) goto L38;
        boolean r112 = kj9.b.f503724a;
        kj9.b.b("[LiveTutorSubtitleController] subtitle tutorPartIdx is small, discard\n" + c(r210));
        return;
    L38:
        Part r113 = (Part) CollectionsKt.lastOrNull(this.f356460d);
        if (r113 == null) goto L151;
        long r114 = r113.getPartId();
        Long r115 = r210.getPartId();
        if (r115 != null) goto L44;
    L46:
        boolean r116 = false;
    L47:
        String r117 = null;
        if (r116 == true) goto L51;
        r113 = null;
    L51:
        if (r113 == null) goto L151;
        Long r118 = r210.getPartId();
        if (r118 == null) goto L56;
        long r119 = r118.longValue();
    L57:
        Integer r120 = r210.getPartInTutorIdx();
        if (r120 == null) goto L60;
        long r121 = r120.intValue();
    L61:
        Integer r122 = r210.getSentenceIdx();
        if (r122 == null) goto L64;
        long r123 = r122.intValue();
    L65:
        Integer r124 = r210.getStartIdx();
        if (r124 == null) goto L68;
        int r125 = r124.intValue();
    L69:
        Integer r126 = r210.getLen();
        if (r126 == null) goto L72;
        int r127 = r126.intValue();
    L73:
        int r128 = r125 + r127;
        Long r129 = r210.getTtsIdx();
        if (r129 == null) goto L76;
        long r130 = r129.longValue();
    L77:
        Pos r131 = new Pos(r119, r121, r123, r128, r130);
        Pos r132 = this.f356463g;
        if (r132 != null) goto L81;
    L97:
        boolean r133 = true;
    L99:
        if (r133 == true) goto L102;
        boolean r134 = kj9.b.f503724a;
        kj9.b.b("[LiveTutorSubtitleController] subtitle pos is invalid, pos = " + r131 + "\n, currentPos = " + this.f356463g);
        return;
    L102:
        Integer r135 = r210.getPartInTutorIdx();
        if (r135 == null) goto L105;
        r110 = r135.intValue();
    L105:
        this.f356462f = r110;
        this.f356464h = r131.getTtsIdx();
        this.f356463g = r131;
        Pos r136 = this.f356463g;
        if (r136 == null) goto L147;
        ArrayList r137 = (ArrayList) this.f356460d;
        ListIterator r138 = r137.listIterator(r137.size());
    L110:
        if (r138.hasPrevious() == false) goto L117;
        Object r139 = r138.previous();
        if (((Part) r139).getPartId() != r136.getPartId()) goto L114;
        boolean r140 = true;
    L115:
        if (r140 == false) goto L110;
    L118:
        Part r141 = (Part) r139;
        if (r141 == null) goto L146;
        List<Sentence> r142 = r141.getSentences();
        if (r142 == null) goto L146;
        StringBuilder r143 = new StringBuilder();
        long r144 = r136.getSentenceIdx();
        Iterator<T> r145 = r142.iterator();
    L125:
        if (r145.hasNext() == false) goto L145;
        Sentence r146 = (Sentence) r145.next();
        if (r146.getSentenceIdx() < r144) goto L128;
        if (r146.getSentenceIdx() != r144) goto L125;
        String r147 = r146.getText();
        int r148 = r136.getEnd();
        if (r148 >= 0) goto L135;
    L142:
        String r149 = "";
    L144:
        r143.append(r149);
        goto L125
    L135:
        if (r147.length() != 0) goto L137;
        boolean r150 = true;
    L138:
        if (r150 == true) goto L142;
        int r151 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(0, 0), r147.length());
        int r152 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r148, 0), r147.length());
        if (r152 <= r151) goto L142;
        r149 = r147.substring(r151, r152);
        goto L144
    L137:
        r150 = false;
        goto L138
    L128:
        r143.append(r146.getText());
        goto L125
    L145:
        r117 = r143.toString();
    L146:
        boolean r153 = kj9.b.f503724a;
        kj9.b.b("[LiveTutorSubtitleController] calculateSubtitle, not found partId = " + r136.getPartId());
        goto L147
    L114:
        r140 = false;
        goto L115
    L117:
        r139 = null;
    L147:
        boolean r154 = kj9.b.f503724a;
        kj9.b.a("[LiveTutorSubtitleController] calculateSubtitle, subtitle = " + r117);
        if (r117 == null) goto L166;
        r113.setCurrentContent$impl_mainlandRelease(r117);
        j(r117);
        return;
    L166:
        return;
    L81:
        if (r131.getParInTutorIdx() > r132.getParInTutorIdx()) goto L97;
        if (r131.getParInTutorIdx() >= r132.getParInTutorIdx()) goto L87;
    L98:
        r133 = false;
        goto L99
    L87:
        if (r131.getTtsIdx() <= r132.getTtsIdx()) goto L98;
        if (r131.getSentenceIdx() > r132.getSentenceIdx()) goto L97;
        if (r131.getSentenceIdx() < r132.getSentenceIdx()) goto L98;
        if (r131.getEnd() < r132.getEnd()) goto L98;
    L76:
        r130 = 0;
        goto L77
    L72:
        r127 = 0;
        goto L73
    L68:
        r125 = 0;
        goto L69
    L64:
        r123 = 0;
        goto L65
    L60:
        r121 = 0;
        goto L61
    L56:
        r119 = 0;
        goto L57
    L44:
        if (r114 != r115.longValue()) goto L46;
        r116 = true;
    L151:
        boolean r155 = kj9.b.f503724a;
        kj9.b.b("[LiveTutorSubtitleController] can not find current part, discard\n" + c(r210));
        return;
    L33:
        r111 = 0;
        goto L35
    L21:
        if (r104.intValue() < 0) goto L23;
        r105 = true;
        goto L24
    L14:
        if (r102.intValue() < 0) goto L16;
        r103 = true;
        goto L17
    L7:
        if (r100.intValue() < 0) goto L9;
        r101 = true;
    L26:
        r106 = false;
        goto L27
    }

    public final void j(String r100) {
        LiveTutorViewModel r101 = this.f356458b;
        if (r101 == null) goto L5;
        r101.reportFirstWordLoading();
    L5:
        r0 r102 = this.f356459c;
        if (r102 == null) goto L9;
        r102.a(r100);
        return;
    }
}
