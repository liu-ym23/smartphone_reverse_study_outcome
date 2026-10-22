package com.larksuite.component.card.component.personlist.avatar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.component.personlist.PersonInfo;
import com.larksuite.component.card.component.personlist.g;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.lynx.tasm.base.TraceEvent;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.utils.y0;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 :2\u00020\u0001:\u0004:;<=B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0014J\u0012\u0010&\u001a\u00020#2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\nH\u0002J\u000e\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020+J\u0016\u0010.\u001a\u00020#2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0002J:\u00102\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u0001062\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\r8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00198FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00060!R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/larksuite/component/card/component/personlist/avatar/PersonAvatarGroupView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ivPersonAvatarGroupLastAvatarFromXml", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "getIvPersonAvatarGroupLastAvatarFromXml", "()Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "setIvPersonAvatarGroupLastAvatarFromXml", "(Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;)V", "tvPersonAvatarGroupMoreNumberFromXml", "Landroid/widget/TextView;", "getTvPersonAvatarGroupMoreNumberFromXml", "()Landroid/widget/TextView;", "setTvPersonAvatarGroupMoreNumberFromXml", "(Landroid/widget/TextView;)V", "rvPersonAvatarGroupFromXml", "Lcom/larksuite/component/card/component/personlist/avatar/NonScrollableRecyclerView;", "getRvPersonAvatarGroupFromXml", "()Lcom/larksuite/component/card/component/personlist/avatar/NonScrollableRecyclerView;", "setRvPersonAvatarGroupFromXml", "(Lcom/larksuite/component/card/component/personlist/avatar/NonScrollableRecyclerView;)V", "avatarSize", "avatarGap", "avatarGroupAdapter", "Lcom/larksuite/component/card/component/personlist/avatar/PersonAvatarGroupView$AvatarGroupAdapter;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "initViews", "adjustSize", "moreTextSize", "setData", "personAvatarInfo", "Lcom/larksuite/component/card/component/personlist/avatar/PersonAvatarGroupShadowNode$PersonAvatarExtraData;", "checker", "Lcom/ss/android/lark/widget/listener/DuplicateEnterChecker;", "showRecyclerView", "personList", "", "Lcom/larksuite/component/card/component/personlist/PersonInfo;", "loadAvatar", "imageView", "Landroid/widget/ImageView;", "avatarKey", "", "entityId", "widthInPx", "heightInPx", "Companion", "ClickMoreListener", "AvatarGroupAdapter", "AvatarItemViewHolder", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PersonAvatarGroupView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LKUIRoundedImageView2 f283447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f283448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public NonScrollableRecyclerView f283449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f283450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f283451e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AvatarGroupAdapter f283452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final rcc.a f283453g;

    public final class AvatarGroupAdapter extends RecyclerView.Adapter<AvatarItemViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AsyncListDiffer<PersonInfo> f283454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PersonAvatarGroupView f283455b;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f283454a.getCurrentList().size();
        }

        public AvatarGroupAdapter(PersonAvatarGroupView r100) {
            this.f283455b = r100;
            this.f283454a = new AsyncListDiffer(this, new PersonAvatarGroupView$AvatarGroupAdapter$mDiffer$1());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            AvatarItemViewHolder r102 = (AvatarItemViewHolder) r100;
            Intrinsics.checkNotNullParameter(r102, "holder");
            PersonInfo r103 = (PersonInfo) ListProtector.get(this.f283454a.getCurrentList(), r101);
            View r104 = r102.itemView;
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.larksuite.component.card.component.personlist.avatar.PersonAvatarImageView");
            PersonAvatarImageView r105 = (PersonAvatarImageView) r104;
            PersonAvatarGroupView r106 = this.f283455b;
            int r107 = r106.f283450d;
            int r108 = r106.f283451e;
            PersonAvatarImageView.a r109 = r105.f283459b;
            if (r109 == null) goto L5;
            r109.f472620a = r107;
            r109.f472621b = r107;
        L5:
            ViewGroup.LayoutParams r110 = r105.getLayoutParams();
            if (r110 == null) goto L8;
            r110.width = r107 - r108;
            r110.height = r107;
        L9:
            Context r111 = this.f283455b.getContext();
            View r112 = r102.itemView;
            Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView r113 = (ImageView) r112;
            String r114 = r103.getAvatarKey();
            String r115 = r103.getId();
            int r116 = this.f283455b.f283450d;
            PersonAvatarGroupView.b(r111, r113, r114, r115, r116, r116);
            return;
        L8:
            r105.setLayoutParams(new ViewGroup.LayoutParams(r107 - r108, r107));
            goto L9
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.card_avatar_item, r100, false);
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.larksuite.component.card.component.personlist.avatar.PersonAvatarImageView");
            return new AvatarItemViewHolder((PersonAvatarImageView) r102);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/card/component/personlist/avatar/PersonAvatarGroupView$AvatarItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "rootView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AvatarItemViewHolder extends RecyclerView.ViewHolder {
        public AvatarItemViewHolder(PersonAvatarImageView r100) {
            Intrinsics.checkNotNullParameter(r100, "rootView");
            super(r100);
        }
    }

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f283456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final rcc.a f283457b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<PersonInfo> f283458c;

        public final Context getContext() {
            return this.f283456a;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            if (this.f283457b.a() == false) goto L6;
            Log.e("PersonAvatarGroupView", "more check isDuplicate: " + this.f283458c.hashCode());
            return;
        L6:
            g r101 = g.f283510a;
            Object r102 = this.f283456a;
            List<PersonInfo> r103 = this.f283458c;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r103, "persons");
            if ((r102 instanceof FragmentActivity) == true) goto L14;
            r102 = AppLifecycle.a.f408803a.f();
            if ((r102 instanceof FragmentActivity) == true) goto L14;
            r102 = null;
        L14:
            if (((FragmentActivity) r102) == null) goto L17;
            int r104 = wy7.b.f561884a;
            wy7.b.b((Activity) r102, r103);
            return;
        }

        public a(Context r100, rcc.a r101, List<PersonInfo> r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "checker");
            Intrinsics.checkNotNullParameter(r102, "persons");
            this.f283456a = r100;
            this.f283457b = r101;
            this.f283458c = r102;
        }
    }

    public static final class b {
    }

    static {
    }

    public final void a() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(R.layout.card_avatar_group_layout, this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-2, this.f283450d));
    }

    public final LKUIRoundedImageView2 getIvPersonAvatarGroupLastAvatarFromXml() {
        KeyEvent.Callback r100 = this.f283447a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.iv_person_avatar_group_last_avatar);
        this.f283447a = (LKUIRoundedImageView2) r100;
    L6:
        return (LKUIRoundedImageView2) r100;
    }

    public final NonScrollableRecyclerView getRvPersonAvatarGroupFromXml() {
        KeyEvent.Callback r100 = this.f283449c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.rv_person_avatar_group);
        this.f283449c = (NonScrollableRecyclerView) r100;
    L6:
        return (NonScrollableRecyclerView) r100;
    }

    public final TextView getTvPersonAvatarGroupMoreNumberFromXml() {
        KeyEvent.Callback r100 = this.f283448b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.tv_person_avatar_group_more_number);
        this.f283448b = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public PersonAvatarGroupView(Context r100) {
        super(r100);
        g.f283510a.getClass();
        this.f283450d = g.d(null);
        this.f283451e = g.a(null);
        this.f283452f = new AvatarGroupAdapter(this);
        this.f283453g = new rcc.a();
        a();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        TraceEvent.beginSection("PersonAvatarGroupView.onDraw");
        super.onDraw(r100);
        TraceEvent.endSection("PersonAvatarGroupView.onDraw");
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void setData(PersonAvatarGroupShadowNode.b r110) {
        Intrinsics.checkNotNullParameter(r110, "personAvatarInfo");
        this.f283450d = r110.f283439a;
        this.f283451e = r110.f283440b;
        int r100 = r110.f283445g;
        ViewGroup.LayoutParams r101 = getLayoutParams();
        int r102 = this.f283450d;
        r101.height = r102;
        if (r102 <= 0) goto L6;
        ViewGroup.LayoutParams r103 = getIvPersonAvatarGroupLastAvatarFromXml().getLayoutParams();
        int r104 = this.f283450d;
        r103.width = r104;
        r103.height = r104;
        ViewGroup.LayoutParams r105 = getTvPersonAvatarGroupMoreNumberFromXml().getLayoutParams();
        int r106 = this.f283450d;
        r105.width = r106;
        r105.height = r106;
        getTvPersonAvatarGroupMoreNumberFromXml().setTextSize(0, a08.b.a(r100, getContext()));
        getRvPersonAvatarGroupFromXml().getLayoutParams().height = this.f283450d;
    L6:
        ArrayList r107 = new ArrayList(r110.f283441c);
        int r108 = r110.f283441c.size();
        Log.i("PersonAvatarGroupView", "setData total = " + r110.f283441c.size() + "  avatarSize:" + this.f283450d);
        setOnClickListener(new a(getContext(), this.f283453g, r107));
        int r109 = r110.f283442d;
        if (r109 <= 5) goto L10;
        r109 = 5;
    L10:
        if (r110.f283443e == false) goto L15;
        int r111 = r108 - r109;
        int r112 = r110.f283446h;
        if (r111 <= r112) goto L14;
        r111 = r112;
    L14:
        getTvPersonAvatarGroupMoreNumberFromXml().setText(Marker.ANY_NON_NULL_MARKER + r111);
        Drawable r113 = getTvPersonAvatarGroupMoreNumberFromXml().getBackground();
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) r113).setColor(r110.f283444f);
        getTvPersonAvatarGroupMoreNumberFromXml().setVisibility(0);
        getIvPersonAvatarGroupLastAvatarFromXml().setVisibility(8);
    L16:
        LinearLayoutManager r114 = new LinearLayoutManager(getContext());
        r114.setOrientation(0);
        getRvPersonAvatarGroupFromXml().setLayoutManager(r114);
        List<PersonInfo> r115 = r107;
        if (r109 <= 0) goto L22;
        int r116 = r107.size();
        r115 = r107;
        if (r109 >= r116) goto L22;
        r115 = r107.subList(0, r109);
    L22:
        if (CollectionUtils.isEmpty(r115) == false) goto L24;
        getRvPersonAvatarGroupFromXml().setVisibility(8);
        return;
    L24:
        List<PersonInfo> r117 = r115;
        if (getIvPersonAvatarGroupLastAvatarFromXml().getVisibility() != 0) goto L33;
        PersonInfo r118 = (PersonInfo) ListProtector.get(r115, r115.size() - 1);
        if (r118 == null) goto L30;
        Context r119 = getContext();
        LKUIRoundedImageView2 r120 = getIvPersonAvatarGroupLastAvatarFromXml();
        String r121 = r118.getAvatarKey();
        String r122 = r118.getId();
        int r123 = this.f283450d;
        b(r119, r120, r121, r122, r123, r123);
    L30:
        if (r115.size() <= 1) goto L32;
        List<PersonInfo> r124 = r115.subList(0, r115.size() - 1);
        getRvPersonAvatarGroupFromXml().setVisibility(0);
        r117 = r124;
        goto L33
    L32:
        getRvPersonAvatarGroupFromXml().setVisibility(8);
        return;
    L33:
        getRvPersonAvatarGroupFromXml().setAdapter(this.f283452f);
        AvatarGroupAdapter r125 = this.f283452f;
        r125.getClass();
        ArrayList r126 = new ArrayList();
        if (r117 == null) goto L54;
        Iterator<T> r127 = r117.iterator();
    L37:
        if (r127.hasNext() == false) goto L54;
        PersonInfo r128 = (PersonInfo) r127.next();
        if (TextUtils.isEmpty(r128.getAvatarKey()) == false) goto L37;
        if (TextUtils.isEmpty(r128.getId()) == true) goto L37;
        String r129 = r128.getId();
        if (r129 == null) goto L37;
        Lazy<SimpleUserLoader> r130 = SimpleUserLoader.f283460d;
        SimpleUserLoader r131 = SimpleUserLoader.a.a();
        r131.getClass();
        Intrinsics.checkNotNullParameter(r129, "userId");
        wy7.c r132 = (wy7.c) ((LinkedHashMap) r131.f283461a).get(r129);
        if (r132 == null) goto L52;
        if ((!TextUtils.isEmpty(r132.f561885a)) == true) goto L50;
        r132 = null;
    L50:
        if (r132 == null) goto L52;
        r128.setAvatarKey(r132.f561885a);
    L52:
        r126.add(r129);
    L54:
        if ((true ^ r126.isEmpty()) == false) goto L56;
        Lazy<SimpleUserLoader> r133 = SimpleUserLoader.f283460d;
        SimpleUserLoader.a.a().b(r126, new e(r125));
    L56:
        r125.f283454a.submitList(r117);
        return;
    L15:
        getTvPersonAvatarGroupMoreNumberFromXml().setVisibility(8);
        getIvPersonAvatarGroupLastAvatarFromXml().setVisibility(0);
        goto L16
    }

    public final void setIvPersonAvatarGroupLastAvatarFromXml(LKUIRoundedImageView2 r100) {
        this.f283447a = r100;
    }

    public final void setRvPersonAvatarGroupFromXml(NonScrollableRecyclerView r100) {
        this.f283449c = r100;
    }

    public final void setTvPersonAvatarGroupMoreNumberFromXml(TextView r100) {
        this.f283448b = r100;
    }

    public PersonAvatarGroupView(Context r100, AttributeSet r101) {
        super(r100, r101);
        g.f283510a.getClass();
        this.f283450d = g.d(null);
        this.f283451e = g.a(null);
        this.f283452f = new AvatarGroupAdapter(this);
        this.f283453g = new rcc.a();
        a();
    }

    public PersonAvatarGroupView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        g.f283510a.getClass();
        this.f283450d = g.d(null);
        this.f283451e = g.a(null);
        this.f283452f = new AvatarGroupAdapter(this);
        this.f283453g = new rcc.a();
        a();
    }

    public static void b(Context r100, ImageView r101, String r102, String r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "imageView");
        if (y0.d(r102) == false) goto L6;
        Log.e("PersonAvatarGroupView", "avatarKey is empty");
        r101.setImageDrawable(AppCompatResources.getDrawable(r100, R.drawable.card_avatar_placeholder));
        return;
    L6:
        AvatarImage r106 = AvatarImage.Builder.obtain(r102, r103, r104, r105).build();
        ImageLoader.with(r100).load(r106).placeholder(R.drawable.card_avatar_placeholder).override(r104, r105).into(r101);
    }
}
