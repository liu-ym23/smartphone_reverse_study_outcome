package com.bytedance.ee.bear.drive.biz.preview.more.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bytedance.ee.bear.document.knowledgeai.DocsKnowledgeAIType;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 %2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001%B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000b¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/more/menu/DriveAIOpenChatMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/IGridMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/ICustomIconDrawableMoreItem;", "pluginHost", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "<init>", "(Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;)V", "availabilitySnapshot", "", "getAvailabilitySnapshot", "()Z", "availabilitySnapshot$delegate", "Lkotlin/Lazy;", "getId", "", "getTitle", "getIcon", "", "getIconTint", "shouldIgnoreIconTint", "getShouldIgnoreIconTint", "getIconDrawable", "Landroid/graphics/drawable/Drawable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "sizePx", "resolveAIProvider", "Lcom/bytedance/ee/bear/document/knowledgeai/DocsKnowledgeAIProvider;", "isVisible", "needShowBadge", "isEnable", "getUnableTips", SendEventContainerMethodParamModel.EventKinds.onClick, "", "extensionProvider", "Lcom/bytedance/ee/bear/drive/core/ai/CcmDriveAIExtensionProvider;", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveAIOpenChatMoreItem extends BaseMoreItem implements IGridMoreItem, sj5.a {
    private static final a Companion = null;
    private static final String FROM_DRIVE_MORE_OPEN_CHAT = "drive_more_open_chat";
    private static final String TAG = "DriveAIOpenChatMoreItem";
    private final Lazy availabilitySnapshot$delegate;
    private final DrivePluginHost pluginHost;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return R.drawable.icon_doubao;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return R.color.icon_n1;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return "open_ai_chat";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public String getUnableTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean needShowBadge() {
        return false;
    }

    private final t75.a extensionProvider() {
        return t75.b.a(this.pluginHost);
    }

    private final boolean getAvailabilitySnapshot() {
        return ((Boolean) this.availabilitySnapshot$delegate.getValue()).booleanValue();
    }

    private final com.bytedance.ee.bear.document.knowledgeai.a resolveAIProvider() {
        return (com.bytedance.ee.bear.document.knowledgeai.a) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.document.knowledgeai.a.class);
    }

    @Override // sj5.a
    public boolean getShouldIgnoreIconTint() {
        resolveAIProvider().c();
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(R.string.LarkCCM_Docs_Doubao_OpenChat_Button);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public boolean isEnable() {
        return getAvailabilitySnapshot();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        return getAvailabilitySnapshot();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem
    public void onClick() {
        extensionProvider().h(this.pluginHost);
        tt5.a.h(TAG, "open drive ai chat from more, opened=false");
    }

    public DriveAIOpenChatMoreItem(DrivePluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        this.pluginHost = r100;
        this.availabilitySnapshot$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new DriveAIOpenChatMoreItem$availabilitySnapshot$2(this));
    }

    public static final /* synthetic */ t75.a access$extensionProvider(DriveAIOpenChatMoreItem r100) {
        return r100.extensionProvider();
    }

    public static final /* synthetic */ DrivePluginHost access$getPluginHost$p(DriveAIOpenChatMoreItem r100) {
        return r100.pluginHost;
    }

    @Override // sj5.a
    public Drawable getIconDrawable(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.ee.bear.document.knowledgeai.a r102 = resolveAIProvider();     // Catch: Throwable -> L11
        if (r102.d() != DocsKnowledgeAIType.FLOW_AI) goto L16;
        Drawable r103 = r102.a(r100, r101);     // Catch: Throwable -> L11
        if (r103 != null) goto L18;
        return r102.b(r100, r101);
    L18:
        return r103;
    L16:
        return null;
    L11:
        th = move-exception;
        tt5.a.e(TAG, "resolve drive open ai chat icon fail", th, false);
        return null;
    }
}
