package tv2;

import androidx.recyclerview.widget.GridLayoutManager;
import com.bytedance.android.live.base.model.message.i6;
import com.bytedance.android.livesdk.widget.ui.NewEmojiSelectPanelV3;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class f extends GridLayoutManager.SpanSizeLookup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewEmojiSelectPanelV3 f547672a;

    public f(NewEmojiSelectPanelV3 r100) {
        this.f547672a = r100;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public final int getSpanSize(int r100) {
        Object r101 = ListProtector.get(this.f547672a.f162159a.f513437a, r100);
        if ((r101 instanceof com.bytedance.android.livesdk.model.e) == false) goto L7;
        return this.f547672a.f162163e;
    L7:
        if ((r101 instanceof com.bytedance.android.live.base.model.data.activityemoji.b) == false) goto L11;
        NewEmojiSelectPanelV3 r102 = this.f547672a;
        return r102.f162163e / r102.f162164f;
    L11:
        if ((r101 instanceof i6) == true) goto L13;
        NewEmojiSelectPanelV3 r103 = this.f547672a;
        return r103.f162163e / r103.f162162d;
    L13:
        return this.f547672a.f162163e;
    }
}
