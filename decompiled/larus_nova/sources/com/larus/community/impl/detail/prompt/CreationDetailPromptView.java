package com.larus.community.impl.detail.prompt;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.community.impl.databinding.LarusCommunityCreationDetailPromptLayoutBinding;
import com.larus.community.impl.detail.bottomtools.CreationDetailBottomToolsView;
import com.larus.nova.R;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.Resource;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.service.AccountService;
import com.larus.ugc.community.adapter.RefViewAdapter;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import v19.b7;
import v19.r5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\u001c\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0002J\"\u0010!\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\rH\u0002J$\u0010%\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010#H\u0002J\u001a\u0010)\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010#H\u0002J\u001a\u0010*\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\n\u001a\u00020\u000bH\u0002J+\u0010+\u001a\u00020\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010,\u001a\u00020\rH\u0002¢\u0006\u0002\u0010-J\u000e\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\rJ2\u00100\u001a\u00020\u00142\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0014\u00102\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000104\u0012\u0004\u0012\u00020\u0014032\u0006\u00105\u001a\u00020\rJ\u0010\u00106\u001a\u00020\u00142\b\u00107\u001a\u0004\u0018\u000108J\u0010\u00109\u001a\u00020\u00142\b\u0010:\u001a\u0004\u0018\u00010;J\u0006\u0010<\u001a\u00020=J\u0006\u0010>\u001a\u00020=R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006?"}, d2 = {"Lcom/larus/community/impl/detail/prompt/CreationDetailPromptView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationDetailPromptLayoutBinding;", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "usageCount", "", "refViewAdapter", "Lcom/larus/ugc/community/adapter/RefViewAdapter;", "creationTrackParamsWrap", "Lcom/larus/community/impl/detail/model/CreationTrackParamsWrap;", "onRefVideoOpenListener", "Lkotlin/Function0;", "", "getOnRefVideoOpenListener", "()Lkotlin/jvm/functions/Function0;", "setOnRefVideoOpenListener", "(Lkotlin/jvm/functions/Function0;)V", "onRefVideoCloseListener", "getOnRefVideoCloseListener", "setOnRefVideoCloseListener", "bindCreation", "fillCaptionText", "fillPromptText", "fillPromptToolView", "fillRefImage", "onClickRefMedia", MapController.ITEM_LAYER_TAG, "Lcom/larus/ugc/community/adapter/RefData;", "canShowRefImageDetail", "openRefImageViewerDialog", "resourceType", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceType;", "refData", "openRefVideoViewerDialog", "mobClickCreationReferenceByType", "fillUseCountText", "forceNoRefDesc", "(Lcom/larus/platform/api/creation/UserCreation;Ljava/lang/Boolean;Z)V", "updateInspirationVisible", "isVisible", "bindAction", "likeAction", "makeSameAction", "Lkotlin/Function1;", "", "makeSameEnabled", "bindCreationLikeState", "likeState", "Lcom/larus/community/impl/detail/bottomtools/CreationLikeState;", "bindCreationRefImagePublicState", "refImagePublicState", "Lcom/larus/community/impl/detail/toptools/CreationRefImagePublicState;", "getToolsView", "Landroid/view/View;", "getUsageCount", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailPromptView extends ConstraintLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f329395h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusCommunityCreationDetailPromptLayoutBinding f329396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UserCreation f329397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f329398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RefViewAdapter f329399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j29.a f329400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f329401f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f329402g;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f329403a = null;

        static {
            int[] r100 = new int[ResourceType.values().length];
            r100[ResourceType.VIDEO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ResourceType.AUDIO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f329403a = r100;
        }
    }

    public final View getToolsView() {
        return this.f329396a.f329065e;
    }

    public final View getUsageCount() {
        return this.f329396a.f329067g;
    }

    public final Function0<Unit> getOnRefVideoCloseListener() {
        return this.f329402g;
    }

    public final Function0<Unit> getOnRefVideoOpenListener() {
        return this.f329401f;
    }

    public CreationDetailPromptView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setOnRefVideoCloseListener(Function0<Unit> r100) {
        this.f329402g = r100;
    }

    public final void setOnRefVideoOpenListener(Function0<Unit> r100) {
        this.f329401f = r100;
    }

    public CreationDetailPromptView(Context r100, AttributeSet r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110);
        LayoutInflater.from(r100).inflate(R.layout.larus_community_creation_detail_prompt_layout, this);
        int r101 = R.id.caption_text;
        AppCompatTextView r102 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.caption_text);
        if (r102 == null) goto L17;
        r101 = R.id.divider;
        View r103 = ViewBindings.findChildViewById(this, R.id.divider);
        if (r103 == null) goto L17;
        r101 = R.id.prompt_text;
        AppCompatTextView r104 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.prompt_text);
        if (r104 == null) goto L17;
        r101 = R.id.prompt_tools_view;
        CreationDetailBottomToolsView r105 = (CreationDetailBottomToolsView) ViewBindings.findChildViewById(this, R.id.prompt_tools_view);
        if (r105 == null) goto L17;
        r101 = R.id.rv_ref_images;
        RecyclerView r106 = (RecyclerView) ViewBindings.findChildViewById(this, R.id.rv_ref_images);
        if (r106 == null) goto L17;
        r101 = R.id.use_count;
        AppCompatTextView r107 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.use_count);
        if (r107 == null) goto L17;
        this.f329396a = new LarusCommunityCreationDetailPromptLayoutBinding(this, r102, r103, r104, r105, r106, r107);
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r101)));
    }

    public final void S5(ResourceType r100, UserCreation r110) {
        j29.a r101 = this.f329400e;
        String r102 = null;
        if (r101 == null) goto L7;
        zp9.g r103 = r101.f497038a;
        if (r103 == null) goto L7;
        String r104 = r103.f573247a;
    L8:
        String r105 = String.valueOf(r104);
        j29.a r106 = this.f329400e;
        if (r106 == null) goto L13;
        zp9.g r107 = r106.f497038a;
        if (r107 == null) goto L13;
        String r108 = r107.f573248b;
    L14:
        String r109 = r110.f364987a;
        UserCreationTrackParams r111 = r110.f365000n;
        if (r111 == null) goto L17;
        r102 = r111.f365040a;
    L17:
        String r112 = zp9.d.d(r110);
        String r113 = zp9.d.c(r110);
        JSONObject r114 = new JSONObject();
        Intrinsics.checkNotNullParameter(r114, "params");
        if (r100 != null) goto L20;
        int r115 = -1;
    L22:
        if (r115 != 1) goto L24;
        String r116 = "click_creation_avatar_reference";
    L37:
        r114.putOpt("current_page", r105);     // Catch: JSONException -> L33
        r114.putOpt("recommend_from", r108);     // Catch: JSONException -> L33
        r114.putOpt(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r109);     // Catch: JSONException -> L33
        r114.putOpt("template_rec_req_id", r102);     // Catch: JSONException -> L33
        r114.putOpt("template_sub_type", r113);     // Catch: JSONException -> L33
        r114.putOpt("template_type", r112);     // Catch: JSONException -> L33
        r114.putOpt("click_from", "caption_detail");     // Catch: JSONException -> L33
    L35:
        TrackParams r117 = new TrackParams().merge(r114);
        by7.a r118 = new by7.a(r116);
        r118.f21463a.merge(r117);
        r118.b();
        return;
    L33:
        e = move-exception;
        FLogger.f375446a.e("CommunityEventHelper", "error in CommunityEventHelper mobClickCreationReference " + e.getLocalizedMessage());
        goto L35
    L24:
        if (r115 != 2) goto L26;
        r116 = "click_creation_image_reference";
        goto L37
    L26:
        if (r115 != 3) goto L39;
        r116 = "click_creation_video_reference";
        goto L37
    L39:
        return;
    L20:
        r115 = p29.a.C7144a.f527468a[r100.ordinal()];
    L13:
        r108 = null;
    L7:
        r104 = null;
        goto L8
    }

    public final void R5(UserCreation r110, Boolean r111, boolean r112) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (r111 == null) goto L87;
        r111.booleanValue();
        boolean r100 = true;
        long r101 = 0;
        String r102 = null;
        String r103 = "";
        if (r110.f364999m == null) goto L34;
        if (r111.booleanValue() == false) goto L28;
        StringBuilder r104 = new StringBuilder();
        int r113 = b7.f552450a;
        Long r114 = r110.f364999m;
        if (r114 == null) goto L13;
        long r115 = r114.longValue();
    L14:
        r104.append(b7.a(r115));
        r104.append(" · ");
        Context r116 = getContext();
        if (r116 == null) goto L26;
        Resources r117 = r116.getResources();
        if (r117 == null) goto L26;
        Long r118 = r110.f364992f;
        if (r118 == null) goto L21;
        int r119 = (int) r118.longValue();
    L22:
        Object[] r120 = new Object[1];
        int r121 = r5.f552608a;
        Context r122 = getContext();
        Long r123 = r110.f364992f;
        if (r123 == null) goto L25;
        r101 = r123.longValue();
    L25:
        r120[0] = r5.a(r122, r101);
        String r105 = r117.getQuantityString(R.plurals.larus_creation_user_count_2, r119, r120);
    L27:
        r104.append(r105);
        String r106 = r104.toString();
    L49:
        UserCreationRefContent r107 = r110.f365001o;
        if (r107 == null) goto L56;
        List<Resource> r108 = r107.f365037c;
        if (r108 == null) goto L56;
        if ((!r108.isEmpty()) != true) goto L56;
        boolean r109 = true;
    L57:
        if (r109 == false) goto L78;
        if (r112 == true) goto L78;
        AuthorInfo r124 = r110.f364993g;
        if (r124 == null) goto L63;
        r102 = r124.f364897b;
    L63:
        if (Intrinsics.areEqual(r102, AccountService.f365697a.getUserId()) == false) goto L78;
        if (q29.i.a() == false) goto L71;
        Resources r125 = getResources();
        if (r125 == null) goto L78;
        String r126 = r125.getString(R.string.larus_creation_detail_ref_tag_visibility);
        if (r126 == null) goto L78;
    L76:
        r103 = r126;
        goto L78
    L71:
        Resources r127 = getResources();
        if (r127 == null) goto L78;
        r126 = r127.getString(R.string.larus_imageDetail_label_private);
        if (r126 != null) goto L76;
    L78:
        if (r103.length() == 0) goto L81;
        r100 = false;
    L81:
        if (r100 == true) goto L84;
        r106 = r106 + " · " + r103;
    L84:
        this.f329396a.f329067g.setText(r106);
        return;
    L56:
        r109 = false;
        goto L57
    L21:
        r119 = 0;
    L26:
        r105 = null;
        goto L27
    L13:
        r115 = System.currentTimeMillis();
        goto L14
    L28:
        int r128 = b7.f552450a;
        Long r129 = r110.f364999m;
        if (r129 == null) goto L31;
        long r130 = r129.longValue();
    L32:
        r106 = b7.a(r130);
        goto L49
    L31:
        r130 = System.currentTimeMillis();
        goto L32
    L34:
        if (r111.booleanValue() == false) goto L48;
        Context r131 = getContext();
        if (r131 == null) goto L47;
        Resources r132 = r131.getResources();
        if (r132 == null) goto L47;
        Long r133 = r110.f364992f;
        if (r133 == null) goto L42;
        int r134 = (int) r133.longValue();
    L43:
        Object[] r135 = new Object[1];
        int r136 = r5.f552608a;
        Context r137 = getContext();
        Long r138 = r110.f364992f;
        if (r138 == null) goto L46;
        r101 = r138.longValue();
    L46:
        r135[0] = r5.a(r137, r101);
        r106 = r132.getQuantityString(R.plurals.larus_creation_user_count_2, r134, r135);
        goto L49
    L42:
        r134 = 0;
    L47:
        r106 = null;
        goto L49
    L48:
        r106 = "";
        goto L49
    }
}
