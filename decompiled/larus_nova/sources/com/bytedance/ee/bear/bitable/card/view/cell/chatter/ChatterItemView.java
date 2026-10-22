package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B)\b\u0007\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001e\u001a\u00020\tH\u0016J\u0016\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rJ%\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00028\u00002\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'¢\u0006\u0002\u0010(J'\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00028\u00002\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H\u0016¢\u0006\u0002\u0010(R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/ChatterItemView;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mDelegate", "Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/IChatterDelegate;", "getMDelegate", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/IChatterDelegate;", "setMDelegate", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/IChatterDelegate;)V", "mAvatar", "Lcom/larksuite/component/universe_design/image/UDAvatar;", "getMAvatar", "()Lcom/larksuite/component/universe_design/image/UDAvatar;", "setMAvatar", "(Lcom/larksuite/component/universe_design/image/UDAvatar;)V", "mName", "Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableAtEditText;", "getMName", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableAtEditText;", "setMName", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableAtEditText;)V", "getLayoutId", "setDelegate", "", "delegate", "bindChatterEntity", "chatter", "localeLang", "", "useInjectLocale", "", "(Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;Ljava/lang/String;Z)V", "setDisplayName", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ChatterItemView<T extends IChatterEntity> extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e<T> f207508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UDAvatar f207509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BitableAtEditText f207510c;

    public ChatterItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChatterItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public int getLayoutId() {
        return R.layout.bitable_card_user_cell_item;
    }

    public final UDAvatar getMAvatar() {
        return this.f207509b;
    }

    public final e<T> getMDelegate() {
        return this.f207508a;
    }

    public final BitableAtEditText getMName() {
        return this.f207510c;
    }

    public final void setDelegate(e<T> r100) {
        this.f207508a = r100;
        BitableAtEditText r101 = this.f207510c;
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.setIPermissionCopyChecker(r100.getPermissionCopyChecker());
        return;
    L8:
        return;
    }

    public final void setMAvatar(UDAvatar r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f207509b = r100;
    }

    public final void setMDelegate(e<T> r100) {
        this.f207508a = r100;
    }

    public final void setMName(BitableAtEditText r100) {
        this.f207510c = r100;
    }

    public ChatterItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this, true);
        setBackground(getResources().getDrawable(R.drawable.bitable_card_user_item_bg));
        this.f207509b = (UDAvatar) findViewById(R.id.user_avatar);
        BitableAtEditText r103 = (BitableAtEditText) findViewById(R.id.user_name);
        this.f207510c = r103;
        if (r103 == null) goto L6;
        r103.setTextIsSelectable(true);
        r103.setClickable(false);
        r103.setCursorVisible(false);
        r103.setKeyListener(null);
        return;
    }

    public /* synthetic */ ChatterItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
