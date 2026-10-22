package com.bytedance.ee.bear.more.protocol3.panel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000O\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u000b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0001J\t\u0010\n\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u000b\u001a\u00020\fH\u0096\u0001J\t\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0014\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0001J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0016H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0016H\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0001J\t\u0010\u001d\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u001e\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u001f\u001a\u00020\u0007H\u0096\u0001J\t\u0010 \u001a\u00020\u0007H\u0096\u0001J\u0011\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\fH\u0096\u0001R\u0014\u0010#\u001a\u00020\u00048VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"com/bytedance/ee/bear/more/protocol3/panel/OverrideUIMoreItemFactory$wrapGridMoreItem$1", "Lcom/bytedance/ee/bear/more/moreprotocol/IGridMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/ICustomIconDrawableMoreItem;", "isVisible", "", "isEnable", SendEventContainerMethodParamModel.EventKinds.onClick, "", "buildUI", "Lcom/bytedance/ee/bear/more/protocol3/UIMoreItem;", "create", "getHost", "Lcom/bytedance/ee/bear/more/moreprotocol/IMoreHost;", "getIcon", "", "getIconDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "sizePx", "getIconTint", "getId", "", "getItemDisableReasonByJSMsg", "getTitle", "getUnableTips", "init", "hostProvider", "Lcom/bytedance/ee/bear/more/protocol3/MoreProvider;", "needShowBadge", "notifyItemChanged", "onRelease", "release", "setHost", "host", "shouldIgnoreIconTint", "getShouldIgnoreIconTint", "()Z", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OverrideUIMoreItemFactory$wrapGridMoreItem$1 implements IGridMoreItem, sj5.a {
    private final /* synthetic */ Object $$delegate_0;
    private final /* synthetic */ sj5.a $$delegate_1;
    final /* synthetic */ x $context;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ q $hostDelegate;
    final /* synthetic */ String $itemId;
    final /* synthetic */ IGridMoreItem $moreItem;
    final /* synthetic */ boolean $visible;
    final /* synthetic */ OverrideUIMoreItemFactory this$0;

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem, com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem, com.bytedance.ee.bear.more.protocol3.b
    public com.bytedance.ee.bear.more.protocol3.k buildUI() {
        return ((IGridMoreItem) this.$$delegate_0).buildUI();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem, com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public void create() {
        ((IGridMoreItem) this.$$delegate_0).create();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public sj5.b getHost() {
        return ((IGridMoreItem) this.$$delegate_0).getHost();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return ((IGridMoreItem) this.$$delegate_0).getIcon();
    }

    @Override // sj5.a
    public Drawable getIconDrawable(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.$$delegate_1.getIconDrawable(r2, r3);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return ((IGridMoreItem) this.$$delegate_0).getIconTint();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return ((IGridMoreItem) this.$$delegate_0).getId();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getItemDisableReasonByJSMsg() {
        return ((IGridMoreItem) this.$$delegate_0).getItemDisableReasonByJSMsg();
    }

    @Override // sj5.a
    public boolean getShouldIgnoreIconTint() {
        return this.$$delegate_1.getShouldIgnoreIconTint();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return ((IGridMoreItem) this.$$delegate_0).getTitle();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public String getUnableTips() {
        return ((IGridMoreItem) this.$$delegate_0).getUnableTips();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem, com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem, com.bytedance.ee.bear.more.protocol3.b
    public void init(com.bytedance.ee.bear.more.protocol3.h r2) {
        Intrinsics.checkNotNullParameter(r2, "hostProvider");
        ((IGridMoreItem) this.$$delegate_0).init(r2);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean needShowBadge() {
        return ((IGridMoreItem) this.$$delegate_0).needShowBadge();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public void notifyItemChanged() {
        ((IGridMoreItem) this.$$delegate_0).notifyItemChanged();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public void onRelease() {
        ((IGridMoreItem) this.$$delegate_0).onRelease();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem, com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem, com.bytedance.ee.bear.more.protocol3.b
    public void release() {
        ((IGridMoreItem) this.$$delegate_0).release();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public void setHost(sj5.b r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        ((IGridMoreItem) this.$$delegate_0).setHost(r2);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public void onClick() {
        if (OverrideUIMoreItemFactory.c(this.this$0, this.$itemId, this.$hostDelegate, this.$context) == true) goto L6;
        this.$moreItem.onClick();
        return;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean isEnable() {
        return this.$enabled;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        return this.$visible;
    }

    public OverrideUIMoreItemFactory$wrapGridMoreItem$1(IGridMoreItem r1, sj5.a r2, boolean r3, boolean r4, OverrideUIMoreItemFactory r5, String r6, q r7, x r8) {
        this.$moreItem = r1;
        this.$visible = r3;
        this.$enabled = r4;
        this.this$0 = r5;
        this.$itemId = r6;
        this.$hostDelegate = r7;
        this.$context = r8;
        this.$$delegate_0 = r1;
        this.$$delegate_1 = r2;
    }
}
