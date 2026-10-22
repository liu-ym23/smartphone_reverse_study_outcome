package com.larus.drive.sdk.impl.view.chat.fileselect.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.locallife.dito.data.DitoNode;
import com.google.gson.Gson;
import com.larus.common_ui.icon.CommonFileIconType;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.select.BaseFileSelectFromType;
import com.larus.drive.sdk.api.file.select.ChatRecentFileSource;
import com.larus.drive.sdk.impl.utils.m;
import com.larus.drive.sdk.impl.view.chat.fileselect.data.ChatRecentFileLoadProcessor;
import com.larus.nova.R;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.api.fileselect.DriveUplinkInfo;
import com.larus.platform.api.fileselect.IChatFileSelectionStore;
import com.larus.platform.api.u;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u001f\u0018\u0000 F2\u00020\u0001:\u0002FGB/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0010H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0010H\u0016J\u0018\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0014J\u0010\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020)H\u0016J\u0006\u00100\u001a\u00020\"J\u0006\u00101\u001a\u00020\"J\b\u00102\u001a\u00020\u0012H\u0002J\u0006\u00103\u001a\u00020\"J\b\u00104\u001a\u00020\u0014H\u0002J\u000e\u00105\u001a\b\u0012\u0004\u0012\u00020\u001d06H\u0002J\u0016\u00107\u001a\u00020\"2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001d06H\u0002J\b\u00109\u001a\u00020\"H\u0002J\u0010\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u0005H\u0002J\f\u0010<\u001a\u00020\u0019*\u00020=H\u0002J\f\u0010>\u001a\u00020\u0003*\u00020?H\u0002J\u0012\u0010@\u001a\u0004\u0018\u00010\u00032\u0006\u0010A\u001a\u00020\u0003H\u0002J\f\u0010B\u001a\u00020)*\u00020=H\u0002J\u000e\u0010C\u001a\u0004\u0018\u00010D*\u00020=H\u0002J\f\u0010E\u001a\u00020\u001d*\u00020\u0019H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u0018j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0019`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0018j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 ¨\u0006H"}, d2 = {"Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/ChatRecentFileSelectAdapter;", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/BaseFileSelectAdapter;", "conversationId", "", "lastChatTime", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "selectCallback", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/ChatRecentFileSelectAdapter$IFileSelectCallback;", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/ChatRecentFileSelectAdapter$IFileSelectCallback;)V", "Ljava/lang/Long;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attachedRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "processor", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/data/ChatRecentFileLoadProcessor;", "isLoadingMore", "", "hasMore", "isFirstLoadPending", "recentItemsMap", "Ljava/util/LinkedHashMap;", "Lcom/larus/platform/api/FlowSelectedFileItem;", "Lkotlin/collections/LinkedHashMap;", "recentItemCreateTimeMap", "loadingFooterItem", "Lcom/larus/drive/sdk/api/file/select/BaseFileSelectConfig;", "scrollListener", "com/larus/drive/sdk/impl/view/chat/fileselect/adapter/ChatRecentFileSelectAdapter$scrollListener$1", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/ChatRecentFileSelectAdapter$scrollListener$1;", "onAttachedToRecyclerView", "", "recyclerView", "onDetachedFromRecyclerView", "bindFileViewHolder", "holder", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/BaseFileSelectAdapter$FileViewHolder;", "position", "", "getItemViewType", "onCreateViewHolder", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/BaseFileSelectAdapter$BaseViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "notifyDisableStateChanged", "updateFileList", "createLoadProcessor", DitoNode.LOAD_MORE, "shouldShowLoadingFooter", "buildSortedRecentList", "", "submitDataListWithFooter", "data", "scheduleLoadMoreIfListCannotScroll", "getFileVisitTimeString", "visitTime", "toSelectedFileItem", "Lcom/larus/drive/sdk/api/file/select/ChatRecentFileItem;", "toExtraValue", "Lcom/larus/drive/sdk/api/file/select/ChatRecentFileSource;", "recentFileIdentity", "uri", "resolveIconResId", "parseValidDriveUplinkInfo", "Lcom/larus/platform/api/fileselect/DriveUplinkInfo;", "toBaseFileSelectConfig", "Companion", "IFileSelectCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatRecentFileSelectAdapter extends BaseFileSelectAdapter {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f342147p = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f342148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f342149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f342150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f342151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f342152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f342153g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ChatRecentFileLoadProcessor f342154h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f342155i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f342156j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f342157k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedHashMap<String, u> f342158l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedHashMap<String, Long> f342159m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final x79.a f342160n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ChatRecentFileSelectAdapter$scrollListener$1 f342161o;

    public static final class a {
    }

    public interface b {
        IChatFileSelectionStore.a a(u r100);

        void b(boolean r100);

        void c(u r100, IChatFileSelectionStore.a r101);

        void d(u r100, boolean r101);
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f342162a = null;

        static {
            int[] r100 = new int[ChatRecentFileSource.values().length];
            r100[ChatRecentFileSource.LARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ChatRecentFileSource.DOUBAO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ChatRecentFileSource.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f342162a = r100;
        }
    }

    static {
    }

    public final void D2() {
        if (this.f342155i == false) goto L5;
        return;
    L5:
        if (this.f342156j == false) goto L15;
        this.f342155i = true;
        if (this.f342157k == false) goto L10;
    L12:
        BuildersKt.launch$default(this.f342150d, null, null, new ChatRecentFileSelectAdapter$loadMore$1(this, null), 3, null);
        return;
    L10:
        if ((true ^ getCurrentList().isEmpty()) == false) goto L12;
        F2(getCurrentList());
        goto L12
    }

    public static final List B2(ChatRecentFileSelectAdapter r110) {
        Collection<u> r100 = r110.f342158l.values();
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        u r103 = (u) r102.next();
        Intrinsics.checkNotNull(r103);
        String r104 = r103.f365280a;
        String r105 = r103.f365281b;
        String r106 = r103.f365283d;
        int r107 = r103.f365284e;
        if (r103.f365285f != FlowDriveFileType.IMAGE) goto L8;
        boolean r108 = true;
    L9:
        r101.add(new x79.a(r104, r105, r106, r107, r108, BaseFileSelectFromType.RECENT, 48));
        goto L4
    L8:
        r108 = false;
        goto L9
    L11:
        return CollectionsKt.sortedWith(r101, new i(r110));
    }

    public static String E2(String r100) {
        String r101 = StringsKt.trim(StringsKt.removePrefix(r100, "imkey://")).toString();
        if (r101.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L10;
        return null;
    L10:
        return r101;
    L5:
        r102 = false;
        goto L6
    }

    public final void F2(List<x79.a> r100) {
        if (this.f342155i == true) goto L5;
    L9:
        boolean r101 = false;
    L11:
        if (r101 == false) goto L19;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L14:
        if (r103.hasNext() == false) goto L18;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((x79.a) r104).f562830a, "__recent_load_more_footer__") == true) goto L14;
        r102.add(r104);
        goto L14
    L18:
        List<x79.a> r105 = CollectionsKt.plus(r102, this.f342160n);
    L26:
        A2(r105);
        return;
    L19:
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r100.iterator();
    L21:
        if (r107.hasNext() == false) goto L25;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(((x79.a) r108).f562830a, "__recent_load_more_footer__") == true) goto L21;
        r106.add(r108);
        goto L21
    L25:
        r105 = r106;
        goto L26
    L5:
        if (this.f342156j == false) goto L9;
        if (this.f342157k == true) goto L9;
        r101 = true;
        goto L11
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (Intrinsics.areEqual(getItem(r100).f562830a, "__recent_load_more_footer__") == false) goto L6;
        return BaseFileSelectAdapter.ViewType.LOADING_FOOTER.getId();
    L6:
        return BaseFileSelectAdapter.ViewType.FILE.getId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        this.f342153g = r100;
        if (this.f342152f != null) goto L5;
        this.f342152f = r100.getContext();
    L5:
        r100.addOnScrollListener(this.f342161o);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        r100.removeOnScrollListener(this.f342161o);
        if (this.f342153g != r100) goto L5;
        this.f342153g = null;
    L5:
        this.f342152f = null;
        super.onDetachedFromRecyclerView(r100);
    }

    public static final u C2(ChatRecentFileSelectAdapter r110, x79.b r111) {
        String r100 = r111.f562844g;
        if (r100 != null) goto L5;
    L40:
        DriveUplinkInfo r101 = null;
    L41:
        String r102 = r111.f562839b;
        String r103 = r111.f562838a;
        long r104 = r111.f562841d;
        String r105 = m.a(r111.f562843f);
        Context r112 = r110.f342152f;
        if (r112 == null) goto L48;
        String r113 = r112.getString(R.string.larus_drive_file_lastViewed_time);
        if (r113 == null) goto L48;
        String r114 = StringsKt.replace$default(r113, "%s", r105, false, 4, null);
        if (r114 == null) goto L48;
    L49:
        DriveFileType r106 = r111.f562842e;
        DriveFileType r115 = DriveFileType.BITABLE;
        if (r106 != r115) goto L54;
        int r107 = bq9.b.f20091a;
        if (bq9.b.a(r111.f562845h, r111.f562840c) == false) goto L54;
        h19.b r108 = h19.b.f483542a;
        CommonFileIconType r116 = CommonFileIconType.BITABLE_APP;
        r108.getClass();
        int r109 = h19.b.a(r116);
    L55:
        int r117 = r109;
        a89.a r118 = com.larus.drive.sdk.impl.utils.h.f342026a;
        FlowDriveFileType r119 = com.larus.drive.sdk.impl.utils.h.b(r111.f562842e);
        String r120 = r111.f562840c;
        DriveFileType r121 = r111.f562842e;
        Intrinsics.checkNotNullParameter(r121, "fileType");
        switch(com.larus.drive.sdk.impl.utils.h.a.f342032b[r121.ordinal()]) {
            case 1: goto L63;
            case 2: goto L62;
            case 3: goto L61;
            case 4: goto L60;
            case 5: goto L59;
            case 6: goto L58;
            default: goto L57;
        };
    L57:
        int r122 = 12;
    L64:
        LinkedHashMap r123 = new LinkedHashMap();
        r123.put("originFileTypeString", r111.f562842e.getValue());
        r123.put("originUrl", r111.f562840c);
        r123.put("upload_way", "recent_sent_file");
        if (r101 == null) goto L67;
        String r124 = "drive";
    L68:
        r123.put("upload_from", r124);
        int r125 = c.f342162a[r111.f562846i.ordinal()];
        if (r125 != 1) goto L71;
        String r126 = "lark";
    L78:
        r123.put("recentFileSource", r126);
        Integer r127 = r111.f562845h;
        if (r127 == null) goto L89;
        r127.intValue();
        if (r111.f562842e != r115) goto L83;
        boolean r128 = true;
    L84:
        if (r128 == true) goto L87;
        r127 = null;
    L87:
        if (r127 == null) goto L89;
        String r129 = (String) r123.put("originBaseBizType", String.valueOf(r127.intValue()));
        goto L89
    L83:
        r128 = false;
    L89:
        if (r101 == null) goto L91;
        r123.put("drive_uplink_info", r101.toString());
    L91:
        Unit r130 = Unit.INSTANCE;
        return new u(r102, r103, r104, r114, r117, r119, r120, r122, r123, 3840);
    L71:
        if (r125 == 2) goto L76;
        if (r125 != 3) goto L75;
        r126 = "unknown";
        goto L78
    L75:
        throw new NoWhenBranchMatchedException();
    L76:
        r126 = "doubao";
        goto L78
    L67:
        r124 = "local";
        goto L68
    L58:
        r122 = 0;
        goto L64
    L59:
        r122 = 11;
        goto L64
    L60:
        r122 = 8;
        goto L64
    L61:
        r122 = 3;
        goto L64
    L62:
        r122 = 30;
        goto L64
    L63:
        r122 = 22;
    L54:
        r109 = r111.f562842e.getIconResId();
    L48:
        r114 = r105;
        goto L49
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L40;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L12
        Object r132 = Result.m9449constructorimpl((DriveUplinkInfo) new Gson().fromJson(r100, DriveUplinkInfo.class));     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r132) == false) goto L17;
        r132 = null;
    L17:
        r101 = (DriveUplinkInfo) r132;
        if (r101 == null) goto L40;
        String r133 = r101.getFileToken();
        if (r133 != null) goto L22;
    L25:
        boolean r134 = true;
    L26:
        if (r134 == false) goto L37;
        String r135 = r101.getUrl();
        if (r135 != null) goto L30;
    L33:
        boolean r136 = true;
    L34:
        if (r136 == false) goto L37;
        boolean r137 = false;
    L38:
        if (r137 == false) goto L40;
    L30:
        if (StringsKt.isBlank(r135) == true) goto L33;
        r136 = false;
    L37:
        r137 = true;
        goto L38
    L22:
        if (StringsKt.isBlank(r133) == true) goto L25;
        r134 = false;
    L12:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // com.larus.drive.sdk.impl.view.chat.fileselect.adapter.BaseFileSelectAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return z2(r100, r101);
    }

    @Override // com.larus.drive.sdk.impl.view.chat.fileselect.adapter.BaseFileSelectAdapter
    public final void y2(BaseFileSelectAdapter.FileViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        x79.a r102 = getItem(r101);
        String r103 = E2(r102.f562830a);
        final IChatFileSelectionStore.a r104 = null;
        if (r103 == null) goto L5;
        final u r105 = this.f342158l.get(r103);
    L6:
        if (r105 == null) goto L10;
        b r106 = this.f342151e;
        if (r106 == null) goto L10;
        r104 = r106.a(r105);
    L10:
        if (r104 == null) goto L12;
        final boolean r107 = true;
    L13:
        Intrinsics.checkNotNull(r102);
        r100.T3(r102, this.f342140a.contains(r102.f562830a), new h(r107, r105, this, r104));
        View r108 = r100.itemView;
        if (r107 == false) goto L16;
        float r109 = 0.3f;
    L17:
        r108.setAlpha(r109);
        return;
    L16:
        r109 = 1.0f;
        goto L17
    L12:
        r107 = false;
        goto L13
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.larus.drive.sdk.impl.view.chat.fileselect.adapter.BaseFileSelectAdapter
    public final BaseFileSelectAdapter.BaseViewHolder z2(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != BaseFileSelectAdapter.ViewType.LOADING_FOOTER.getId()) goto L6;
        return new BaseFileSelectAdapter.LoadMoreFooterViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_chat_recent_load_more_footer, r100, false));
    L6:
        return super.z2(r100, r101);
    }

    /* JADX WARN: Type inference failed for: r11v5, types: [com.larus.drive.sdk.impl.view.chat.fileselect.adapter.ChatRecentFileSelectAdapter$scrollListener$1] */
    public ChatRecentFileSelectAdapter(String r100, Long r110, LifecycleCoroutineScope r111, com.larus.drive.sdk.impl.view.chat.fileselect.i r112) {
        Intrinsics.checkNotNullParameter(r111, "scope");
        this.f342148b = r100;
        this.f342149c = r110;
        this.f342150d = r111;
        this.f342151e = r112;
        this.f342156j = true;
        this.f342158l = new LinkedHashMap();
        this.f342159m = new LinkedHashMap();
        this.f342160n = new x79.a("__recent_load_more_footer__", "", "", 0, false, BaseFileSelectFromType.LOCAL, 112);
        this.f342161o = new ChatRecentFileSelectAdapter$scrollListener$1(this);
        if (r110 == null) goto L5;
        long r101 = r110.longValue();
    L6:
        this.f342154h = new ChatRecentFileLoadProcessor(r100, r101);
        return;
    L5:
        r101 = System.currentTimeMillis();
        goto L6
    }
}
