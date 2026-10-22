package com.ss.android.lark.todo.impl.features.detail.comment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.bytedance.lark.pb.basic.v1.RichContent;
import com.bytedance.lark.pb.todo.v1.TodoAttachment;
import com.bytedance.lark.pb.todo.v1.TodoComment;
import com.bytedance.lark.pb.todo.v1.TodoCommentReaction;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.TimePreciseness;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoAttachmentData;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextView;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001c\u001dB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u001c\u0010\u0018\u001a\u00020\u00102\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/comment/CommentAdapterV2;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/todo/impl/features/detail/comment/CommentAdapterV2$ViewHolder;", "viewAbility", "Lcom/larksuite/framework/section/IViewAbility;", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/ITodoDetailViewDataStore;", "<init>", "(Lcom/larksuite/framework/section/IViewAbility;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "data", "", "Lcom/ss/android/lark/todo/impl/features/detail/comment/TodoCommentData;", "reactionMaxWidth", "", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "computeReactionMaxWidth", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "ViewHolder", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentAdapterV2 extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c7c.a f442829d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f442830e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final RichText f442831f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> f442832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<z0> f442833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f442834c;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/comment/CommentAdapterV2$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/ss/android/lark/todo/impl/features/detail/comment/CommentAdapterV2;Landroid/view/View;)V", "bind", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "itemData", "Lcom/ss/android/lark/todo/impl/features/detail/comment/TodoCommentData;", "position", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentAdapterV2 f442835a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f442836a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int[] f442837b = null;

            static {
                int[] r100 = new int[TodoComment.Status.values().length];
                r100[TodoComment.Status.EDITED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L4:
                f442836a = r100;
                int[] r101 = new int[TodoComment.Type.values().length];
                r101[TodoComment.Type.UNKNOWN_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L6:
                f442837b = r101;
            }
        }

        public ViewHolder(CommentAdapterV2 r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f442835a = r100;
            super(r101);
        }
    }

    public static final class a {
        public a() {
        }

        public static final void a(Context r100, String r101) {
            c7c.a r102 = CommentAdapterV2.f442829d;
            TodoDependencyHolder.a().messengerModuleDependency().a(r100, r101);
        }
    }

    static {
        new a();
        c7c.a r100 = new c7c.a(null, null, null, null, null, false, false, false, false, 2047);
        r100.b(DisplayPattern.RELATIVE);
        r100.d(TimePreciseness.MINUTE);
        r100.f22684h = !TodoDependencyHolder.a().timeFormatDependency().c();
        r100.f22686j = true;
        f442829d = r100;
        f442830e = UIHelper.getString(R.string.Todo_Task_EditedComment);
        f442831f = com.ss.android.lark.widget.richtext.c.c(UIHelper.getString(R.string.Todo_Task_UnsupportedComment));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<z0> r100 = this.f442833b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public CommentAdapterV2(com.larksuite.framework.section.g r100) {
        Intrinsics.checkNotNullParameter(r100, "viewAbility");
        this.f442832a = r100;
        this.f442834c = -1;
        ((com.ss.android.lark.todo.impl.features.detail.viewmodel.p) r100.f285689b).getCommentLv().observe(r100.b(), new com.ss.android.lark.todo.impl.features.detail.comment.a(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        Context r101 = r100.getContext();
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        r101 = null;
    L5:
        this.f442834c = UIHelper.getWindowWidth(r101) - UIHelper.dp2px(70.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10, types: [T, com.ss.android.lark.widget.richtext.RichText] */
    /* JADX WARN: Type inference failed for: r11v28, types: [T, com.ss.android.lark.widget.richtext.RichText] */
    /* JADX WARN: Type inference failed for: r11v8, types: [T, com.ss.android.lark.widget.richtext.RichText] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        ViewHolder r100 = (ViewHolder) r110;
        Intrinsics.checkNotNullParameter(r100, "holder");
        List<z0> r101 = this.f442833b;
        if (r101 == null) goto L5;
        final z0 r102 = (z0) ListProtector.get(r101, r111);
    L6:
        if (r102 == null) goto L124;
        Context r103 = this.f442832a.provideContext();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "itemData");
        TodoComment r104 = r102.f443017a;
        View r105 = r100.itemView;
        CommentAdapterV2 r106 = r100.f442835a;
        r105.setOnLongClickListener(new c(r106, r100, r104));
        TextView r107 = (TextView) r105.findViewById(R.id.commenterNameTv);
        TodoUser r108 = r104.from_user;
        if (r108 == null) goto L10;
        r107.setText(r108.name);
        r107.setOnClickListener(new d(r103, r108));
    L10:
        TextView r109 = (TextView) r105.findViewById(R.id.commentTimeTv);
        TodoComment.Status r112 = r104.status;
        if (r112 != null) goto L13;
        int r113 = -1;
    L15:
        if (r113 != 1) goto L17;
        Long r114 = r104.update_milli_time;
    L18:
        Intrinsics.checkNotNull(r114);
        r109.setText(c7c.b.c(r103, new Date(r114.longValue()), f442829d));
        TextView r115 = (TextView) r105.findViewById(R.id.commentEditedTv);
        TodoComment.Status r116 = r104.status;
        if (r116 != null) goto L21;
        int r117 = -1;
    L23:
        if (r117 != 1) goto L25;
        int r118 = 0;
    L26:
        r115.setVisibility(r118);
        r115.setText(f442830e);
        LKUIRoundedImageView2 r119 = (LKUIRoundedImageView2) r105.findViewById(R.id.commenterAvatarIv);
        TodoUser r120 = r104.from_user;
        if (r120 == null) goto L29;
        int r121 = (int) UIUtils.sp2px(LarkContext.getApplication(), 40.0f);
        ImageLoader.with(r103).load(AvatarImage.Builder.obtain(r120.avatar_key, r120.user_id, r121, r121).build()).override(r121, r121).into(r119);
        r119.setOnClickListener(new e(r103, r120));
    L29:
        RichTextView r122 = (RichTextView) r105.findViewById(R.id.commentContentTv);
        r122.setAtTextColor(R.color.text_link_normal);
        r122.setAtSelfTextColor(R.color.text_link_normal);
        r122.setAtOtherChatUserTextColor(R.color.text_caption);
        r122.setAtSelfBgColor(R.color.lkui_transparent);
        r122.setDefaultAtUserColor(UIHelper.getColor(R.color.text_link_normal));
        r122.setUrlTextColor(UIHelper.getColor(R.color.text_link_normal));
        r122.setTextSize(UIHelper.dp2px(14.0f));
        r122.setShowImage(true);
        r122.setShowVideo(false);
        r122.setNeedToRecognizePhone(false);
        r122.setUrlStringClickListner(new f(r103));
        r122.setAtStringClickListner(new g(r103));
        r122.setRichTextListener(new h(r106, r100, r104));
        Ref.ObjectRef r123 = new Ref.ObjectRef();
        TodoComment.Type r124 = r104.type;
        if (r124 != null) goto L32;
        int r125 = -1;
    L33:
        if (r125 != 1) goto L35;
        r123.element = f442831f;
    L38:
        r122.setInfo((RichText) r123.element);
        int r126 = com.ss.android.lark.todo.impl.utils.j.f444292a;
        Intrinsics.checkNotNullParameter(r122, "richTextView");
        if (r122.getChildCount() == 0) goto L43;
        View r127 = r122.getChildAt(0);
        if ((r127 instanceof LKUILightTextView) == false) goto L43;
        LKUILightTextView r128 = (LKUILightTextView) r127;
    L44:
        if (r128 == null) goto L46;
        r128.setImageSpanClickListener(new i(r123, r106, r104));
    L46:
        TodoComment.Type r129 = r104.type;
        TodoComment.Type r130 = TodoComment.Type.UNKNOWN_TYPE;
        if (r129 == r130) goto L55;
        RichContent r131 = r104.rich_content;
        if (r131 == null) goto L51;
        com.bytedance.lark.pb.basic.v1.RichText r132 = r131.rich_text;
    L53:
        if (com.ss.android.lark.widget.richtext.i.l(j8c.c.a(r132)) == false) goto L55;
        int r133 = 8;
    L56:
        r122.setVisibility(r133);
        RecyclerView r134 = (RecyclerView) r105.findViewById(R.id.commentImageGridRv);
        List<TodoAttachment> r135 = r104.attachments;
        if (r135 != null) goto L59;
    L62:
        boolean r136 = true;
    L63:
        if (r136 == false) goto L65;
    L74:
        r134.setVisibility(8);
    L75:
        RecyclerView r137 = (RecyclerView) r105.findViewById(R.id.commentAttachmentRv);
        List<TodoAttachment> r138 = r104.file_attachments;
        if (r138 != null) goto L78;
    L81:
        boolean r139 = true;
    L82:
        if (r139 == false) goto L84;
    L91:
        r137.setVisibility(8);
    L92:
        ReactionFlowLayout r140 = (ReactionFlowLayout) r105.findViewById(R.id.commentReactionContainer);
        r140.setTagBackgroundColor(0);
        r140.setNewReactionEnable(true);
        r140.setReactionMaxWidth(r106.f442834c);
        r140.setReactionPaddings(null);
        r140.setReactionPaddings(new int[]{0, 0, 0, 0});
        r140.setReactionTopMargin(UIHelper.dp2px(4.0f));
        r140.setReactionLeftMargin(UIHelper.dp2px(6.0f));
        r140.setChildXOffset(0);
        r140.setChildYOffset(0);
        List<TodoCommentReaction> r141 = r104.reactions;
        ArrayList r142 = new ArrayList();
        Iterator<T> r143 = r141.iterator();
    L94:
        if (r143.hasNext() == false) goto L101;
        Object r144 = r143.next();
        if (((TodoCommentReaction) r144).users.size() == 0) goto L98;
        boolean r145 = true;
    L99:
        if (r145 == false) goto L94;
        r142.add(r144);
        goto L94
    L98:
        r145 = false;
        goto L99
    L101:
        ArrayList r146 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r142, 10));
        Iterator r147 = r142.iterator();
    L103:
        if (r147.hasNext() == false) goto L109;
        TodoCommentReaction r148 = (TodoCommentReaction) r147.next();
        Intrinsics.checkNotNull(r148);
        q2c.c r149 = new q2c.c();
        r149.f531474a = r148.type;
        r149.f531475b = r148.users.size();
        List<TodoUser> r150 = r148.users;
        ArrayList r151 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r150, 10));
        Iterator<T> r152 = r150.iterator();
    L106:
        if (r152.hasNext() == false) goto L108;
        TodoUser r153 = (TodoUser) r152.next();
        q2c.d r154 = new q2c.d();
        r154.f531477a = r153.user_id;
        r154.f531478b = r153.name;
        r151.add(r154);
        goto L106
    L108:
        r149.f531476c = r151;
        r146.add(r149);
        goto L103
    L109:
        r140.setup(r146);
        r140.setReactionClickListener(new j(r106, r104));
        r140.setOnReactionNameTrigger(new k(r103));
        r140.setOnReactionMoreTrigger(new l(r104, r106, r103));
        ((ImageView) r105.findViewById(R.id.commentMoreIv)).setOnClickListener(new b(r106, r100, r104));
        return;
    L84:
        if (r104.type == TodoComment.Type.UNKNOWN_TYPE) goto L91;
        r137.setVisibility(0);
        List<TodoAttachment> r155 = r104.file_attachments;
        ArrayList r156 = new ArrayList();
        Iterator<T> r157 = r155.iterator();
    L88:
        if (r157.hasNext() == false) goto L90;
        TodoAttachment r158 = (TodoAttachment) r157.next();
        Intrinsics.checkNotNull(r158);
        r156.add(new TodoAttachmentData(r158));
        goto L88
    L90:
        List r159 = CollectionsKt.sortedWith(r156, new m());
        r137.setLayoutManager(new LinearLayoutManager(r103));
        r137.setAdapter(new CommentAttachmentAdapter(r159, r102.f443018b, new CommentAdapterV2$ViewHolder$bind$1$8$1(r102)));
        goto L92
    L78:
        if (r138.isEmpty() == true) goto L81;
        r139 = false;
        goto L82
    L65:
        if (r104.type == r130) goto L74;
        r134.setVisibility(0);
        List<TodoAttachment> r160 = r104.attachments;
        ArrayList r161 = new ArrayList();
        Iterator<T> r162 = r160.iterator();
    L69:
        if (r162.hasNext() == false) goto L73;
        ImageSet r163 = ((TodoAttachment) r162.next()).image_set;
        if (r163 == null) goto L69;
        r161.add(r163);
        goto L69
    L73:
        r134.setLayoutManager(new GridLayoutManager(r103, RangesKt.coerceAtMost(r161.size(), 3)));
        r134.setAdapter(new NineSquaresAdapter(r161));
        goto L75
    L59:
        if (r135.isEmpty() == true) goto L62;
        r136 = false;
        goto L63
    L51:
        r132 = null;
    L55:
        r133 = 0;
    L43:
        r128 = null;
        goto L44
    L35:
        ?? r164 = j8c.f.a(r104.rich_content);
        r123.element = r164;
        if (com.ss.android.lark.widget.richtext.i.l(r164) == false) goto L38;
        r123.element = f442831f;
        goto L38
    L32:
        r125 = ViewHolder.a.f442837b[r124.ordinal()];
        goto L33
    L25:
        r118 = 8;
        goto L26
    L21:
        r117 = ViewHolder.a.f442836a[r116.ordinal()];
        goto L23
    L17:
        r114 = r104.create_milli_time;
        goto L18
    L13:
        r113 = ViewHolder.a.f442836a[r112.ordinal()];
        goto L15
    L124:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.todo_item_comment, r100, false);
        Intrinsics.checkNotNull(r102);
        return new ViewHolder(this, r102);
    }
}
