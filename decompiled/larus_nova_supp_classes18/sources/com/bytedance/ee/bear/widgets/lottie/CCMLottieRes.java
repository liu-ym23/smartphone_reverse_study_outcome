package com.bytedance.ee.bear.widgets.lottie;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/widgets/lottie/CCMLottieRes;", "", ResourceData.KEY_TYPE, "", "resId", "<init>", "(Ljava/lang/String;III)V", "getType", "()I", "getResId", "SEA_WAVE", "SINE_WAVE", "FIREWORK", "AUDIO_SPECTRUM", "getEntryName", "", "getQualifiedName", "Companion", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CCMLottieRes extends Enum<CCMLottieRes> {
    public static final CCMLottieRes AUDIO_SPECTRUM = null;
    public static final a Companion = null;
    public static final CCMLottieRes FIREWORK = null;
    public static final CCMLottieRes SEA_WAVE = null;
    public static final CCMLottieRes SINE_WAVE = null;
    public static final /* synthetic */ CCMLottieRes[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int resId;
    private final int type;

    public static EnumEntries<CCMLottieRes> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.widgets.lottie.CCMLottieRes$a] */
    static {
        CCMLottieRes r0 = new CCMLottieRes("SEA_WAVE", 0, 0, 2131820556);
        SEA_WAVE = r0;
        CCMLottieRes r1 = new CCMLottieRes("SINE_WAVE", 1, 1, 2131820557);
        SINE_WAVE = r1;
        CCMLottieRes r3 = new CCMLottieRes("FIREWORK", 2, 2, 2131820558);
        FIREWORK = r3;
        CCMLottieRes r5 = new CCMLottieRes("AUDIO_SPECTRUM", 3, 3, 2131820559);
        AUDIO_SPECTRUM = r5;
        CCMLottieRes[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static CCMLottieRes[] values() {
        return (CCMLottieRes[]) a.clone();
    }

    public final String getEntryName() {
        return LarkContext.getApplication().getResources().getResourceEntryName(this.resId);
    L4:
        e = move-exception;
        tt5.a.e("CCMLottieRes", "getEntryName, entry name not found, error:", e, false);
        return null;
    }

    public final String getQualifiedName() {
        return LarkContext.getApplication().getResources().getResourceName(this.resId);
    L4:
        e = move-exception;
        tt5.a.e("CCMLottieRes", "getQualifiedName, qualified name not found, error:", e, false);
        return null;
    }

    public final int getResId() {
        return this.resId;
    }

    public final int getType() {
        return this.type;
    }

    public static CCMLottieRes valueOf(String r1) {
        return (CCMLottieRes) r27.a.a(CCMLottieRes.class, r1);
    }

    public CCMLottieRes(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.type = r3;
        this.resId = r4;
    }
}
