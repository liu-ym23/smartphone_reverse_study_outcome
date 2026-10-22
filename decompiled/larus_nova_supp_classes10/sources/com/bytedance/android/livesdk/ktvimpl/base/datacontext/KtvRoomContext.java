package com.bytedance.android.livesdk.ktvimpl.base.datacontext;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.karaokestation.model.v;
import com.bytedance.android.live.ktv.common.model.bean.b;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.previewsongs.KtvPreviewSongsViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvGroupViewModel;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.e;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 D2\u00020\u0001:\u0001EB\u0007¢\u0006\u0004\bB\u0010CJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u0014\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u001cR!\u0010'\u001a\b\u0012\u0004\u0012\u00020#0\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000e\u001a\u0004\b%\u0010&R!\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000e\u001a\u0004\b*\u0010\u0010R!\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u000e\u001a\u0004\b-\u0010&R!\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000e\u001a\u0004\b/\u0010\u001cR!\u00104\u001a\b\u0012\u0004\u0012\u0002010\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u000e\u001a\u0004\b3\u0010\u0010R-\u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000201050\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u000e\u001a\u0004\b8\u0010&R!\u0010<\u001a\b\u0012\u0004\u0012\u0002060\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u000e\u001a\u0004\b;\u0010&R!\u0010?\u001a\b\u0012\u0004\u0012\u0002060\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u000e\u001a\u0004\b>\u0010&R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u000e\u001a\u0004\bA\u0010&¨\u0006F"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/datacontext/KtvRoomContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "isKtvRoomEnterGetOrderSongSuccess", "ktvRoomEnterGetOrderSongSuccess", "", "setKtvRoomEnterGetOrderSongSuccess", "Lio/reactivex/functions/Consumer;", "consumer", "Lio/reactivex/disposables/Disposable;", "observeKtvRoomEnterGetOrderSongSuccess", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/previewsongs/KtvPreviewSongsViewModel;", "previewViewModel$delegate", "Lcom/bytedance/live/datacontext/p;", "getPreviewViewModel", "()Lcom/bytedance/live/datacontext/n;", "previewViewModel", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvGroupViewModel;", "ktvGroupViewModel$delegate", "getKtvGroupViewModel", "()Lcom/bytedance/live/datacontext/j;", "ktvGroupViewModel", "Lcom/bytedance/live/datacontext/k;", "Lcom/bytedance/android/live/ktv/common/karaokestation/model/v;", "requestDownloadMusic$delegate", "getRequestDownloadMusic", "()Lcom/bytedance/live/datacontext/k;", "requestDownloadMusic", "Lcom/bytedance/android/live/ktv/common/model/bean/b;", "downloadProcess$delegate", "getDownloadProcess", "downloadProcess", "Lcom/bytedance/live/datacontext/m;", "", "relevantLiveSongId$delegate", "getRelevantLiveSongId", "()Lcom/bytedance/live/datacontext/m;", "relevantLiveSongId", "", "relevantLiveSongName$delegate", "getRelevantLiveSongName", "relevantLiveSongName", "isMidiOpened$delegate", "isMidiOpened", "originSwitch$delegate", "getOriginSwitch", "originSwitch", "", "reportMidiScore$delegate", "getReportMidiScore", "reportMidiScore", "", "", "scoreMap$delegate", "getScoreMap", "scoreMap", "midiSingLyricsLineCount$delegate", "getMidiSingLyricsLineCount", "midiSingLyricsLineCount", "midiTotalLyricsLineCount$delegate", "getMidiTotalLyricsLineCount", "midiTotalLyricsLineCount", "ktvRoomEnterGetOrderSongSuccess$delegate", "getKtvRoomEnterGetOrderSongSuccess", "<init>", "()V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p downloadProcess$delegate;
    private final p isMidiOpened$delegate;
    private final p ktvGroupViewModel$delegate;
    private final p ktvRoomEnterGetOrderSongSuccess$delegate;
    private final p midiSingLyricsLineCount$delegate;
    private final p midiTotalLyricsLineCount$delegate;
    private final p originSwitch$delegate;
    private final p previewViewModel$delegate;
    private final p relevantLiveSongId$delegate;
    private final p relevantLiveSongName$delegate;
    private final p reportMidiScore$delegate;
    private final p requestDownloadMusic$delegate;
    private final p scoreMap$delegate;

    public static final class a {
        public static KtvRoomContext a() {
            DataContext r0 = d.d(KtvRoomContext.class);
            if ((r0 instanceof KtvRoomContext) == true) goto L6;
            r0 = null;
        L6:
            return (KtvRoomContext) r0;
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(KtvRoomContext.class, "previewViewModel", "getPreviewViewModel()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvRoomContext.class, "ktvGroupViewModel", "getKtvGroupViewModel()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvRoomContext.class, "requestDownloadMusic", "getRequestDownloadMusic()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(KtvRoomContext.class, "downloadProcess", "getDownloadProcess()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(KtvRoomContext.class, "relevantLiveSongId", "getRelevantLiveSongId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvRoomContext.class, "relevantLiveSongName", "getRelevantLiveSongName()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvRoomContext.class, "isMidiOpened", "isMidiOpened()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvRoomContext.class, "originSwitch", "getOriginSwitch()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(KtvRoomContext.class, "reportMidiScore", "getReportMidiScore()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvRoomContext.class, "scoreMap", "getScoreMap()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvRoomContext.class, "midiSingLyricsLineCount", "getMidiSingLyricsLineCount()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvRoomContext.class, "midiTotalLyricsLineCount", "getMidiTotalLyricsLineCount()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvRoomContext.class, "ktvRoomEnterGetOrderSongSuccess", "getKtvRoomEnterGetOrderSongSuccess()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    private final m<Boolean> getKtvRoomEnterGetOrderSongSuccess() {
        return (m) this.ktvRoomEnterGetOrderSongSuccess$delegate.a(this, $$delegatedProperties[12]);
    }

    public final k<b> getDownloadProcess() {
        return (k) this.downloadProcess$delegate.a(this, $$delegatedProperties[3]);
    }

    public final j<KtvGroupViewModel> getKtvGroupViewModel() {
        return (j) this.ktvGroupViewModel$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Integer> getMidiSingLyricsLineCount() {
        return (m) this.midiSingLyricsLineCount$delegate.a(this, $$delegatedProperties[10]);
    }

    public final m<Integer> getMidiTotalLyricsLineCount() {
        return (m) this.midiTotalLyricsLineCount$delegate.a(this, $$delegatedProperties[11]);
    }

    public final k<Boolean> getOriginSwitch() {
        return (k) this.originSwitch$delegate.a(this, $$delegatedProperties[7]);
    }

    public final n<KtvPreviewSongsViewModel> getPreviewViewModel() {
        return (n) this.previewViewModel$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<Long> getRelevantLiveSongId() {
        return (m) this.relevantLiveSongId$delegate.a(this, $$delegatedProperties[4]);
    }

    public final n<String> getRelevantLiveSongName() {
        return (n) this.relevantLiveSongName$delegate.a(this, $$delegatedProperties[5]);
    }

    public final n<Float> getReportMidiScore() {
        return (n) this.reportMidiScore$delegate.a(this, $$delegatedProperties[8]);
    }

    public final k<v> getRequestDownloadMusic() {
        return (k) this.requestDownloadMusic$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<Map<Integer, Float>> getScoreMap() {
        return (m) this.scoreMap$delegate.a(this, $$delegatedProperties[9]);
    }

    public final m<Boolean> isMidiOpened() {
        return (m) this.isMidiOpened$delegate.a(this, $$delegatedProperties[6]);
    }

    public KtvRoomContext() {
        ALogger.i("checkKtvRoomContext", "KtvRoomContext init");
        com.bytedance.live.datacontext.b.a(this, KtvRoomContext.class);
        this.previewViewModel$delegate = q.c(this);
        this.ktvGroupViewModel$delegate = ConstantKt.c(this);
        this.requestDownloadMusic$delegate = e.b(this);
        this.downloadProcess$delegate = e.b(this);
        this.relevantLiveSongId$delegate = q.d(this, 0L);
        this.relevantLiveSongName$delegate = q.c(this);
        Boolean r0 = Boolean.FALSE;
        this.isMidiOpened$delegate = q.d(this, r0);
        this.originSwitch$delegate = e.b(this);
        this.reportMidiScore$delegate = q.c(this);
        this.scoreMap$delegate = q.d(this, new LinkedHashMap());
        this.midiSingLyricsLineCount$delegate = q.d(this, 0);
        this.midiTotalLyricsLineCount$delegate = q.d(this, 0);
        this.ktvRoomEnterGetOrderSongSuccess$delegate = q.d(this, r0);
    }

    public final boolean isKtvRoomEnterGetOrderSongSuccess() {
        return ((Boolean) getKtvRoomEnterGetOrderSongSuccess().getValue()).booleanValue();
    }

    public final Disposable observeKtvRoomEnterGetOrderSongSuccess(Consumer<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "consumer");
        ALogger.i("checkKtvRoomContext", "observeKtvRoomEnterGetOrderSongSuccess:---" + this);
        return getKtvRoomEnterGetOrderSongSuccess().a().subscribe(r3);
    }

    public final void setKtvRoomEnterGetOrderSongSuccess(boolean r3) {
        ALogger.i("checkKtvRoomContext", "ktvRoomEnterGetOrderSongSuccess:" + r3 + "---" + this);
        getKtvRoomEnterGetOrderSongSuccess().setValue(Boolean.valueOf(r3));
    }
}
