package com.ss.android.lark.flow.chat.page.flow.plugin;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowRelationshipBanner extends wya.a<d> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f422763g = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/flow/chat/page/flow/plugin/FlowRelationshipBanner$Type;", "", "<init>", "(Ljava/lang/String;I)V", "STRANGER", "BLOCK", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type BLOCK = null;
        public static final Type STRANGER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f422764a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f422765b = null;

        public static EnumEntries<Type> getEntries() {
            return f422765b;
        }

        static {
            Type r100 = new Type("STRANGER", 0);
            STRANGER = r100;
            Type r101 = new Type("BLOCK", 1);
            BLOCK = r101;
            Type[] r102 = {r100, r101};
            f422764a = r102;
            f422765b = EnumEntriesKt.enumEntries(r102);
        }

        public static Type[] values() {
            return (Type[]) f422764a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a extends wya.a.AbstractC8174a {
        public a() {
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f422766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f422767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CharSequence f422768c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f422766a, r101.f422766a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f422767b, r101.f422767b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f422768c, r101.f422768c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f422766a.hashCode() * 31) + this.f422767b.hashCode()) * 31) + this.f422768c.hashCode();
        }

        public final String toString() {
            return "Content(icon=" + this.f422766a + ", title=" + this.f422767b + ", description=" + this.f422768c + ')';
        }

        public c(Drawable r100, CharSequence r101, CharSequence r102) {
            Intrinsics.checkNotNullParameter(r100, "icon");
            Intrinsics.checkNotNullParameter(r101, "title");
            Intrinsics.checkNotNullParameter(r102, "description");
            this.f422766a = r100;
            this.f422767b = r101;
            this.f422768c = r102;
        }
    }

    public static final class d implements wya.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f422769a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f422769a == ((d) r100).f422769a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f422769a.hashCode();
        }

        public final String toString() {
            return "Data(type=" + this.f422769a + ')';
        }

        public final Type getType() {
            return this.f422769a;
        }

        public d(Type r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            this.f422769a = r100;
        }
    }

    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f422770a = null;

        static {
            int[] r100 = new int[Type.values().length];
            r100[Type.STRANGER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Type.BLOCK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f422770a = r100;
        }
    }

    static {
    }

    @Override // wya.a, wya.b
    public final int getLayoutId() {
        return R.layout.flow_relationship_banner;
    }

    @Override // wya.a, wya.b
    public int getType() {
        return 2048;
    }

    public FlowRelationshipBanner(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        super(r100);
    }

    @Override // wya.b
    public final /* bridge */ /* synthetic */ void d(wya.c r100) {
        f((d) r100);
    }

    public final void f(d r100) {
        View r101 = this.f561892f;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        Context r102 = r101.getContext();
        Type r103 = r100.getType();
        int r104 = e.f422770a[r103.ordinal()];
        if (r104 != 1) goto L10;
        c r105 = new c(UIUtils.getDrawable(r102, R.drawable.flow_ud_ic_stranger_icon), UIUtils.getString(r102, R.string.LarkIM_Dm_StrangerMessage_Title), UIUtils.getString(r102, R.string.LarkIM_Dm_MsgReadOnReply_Desc));
    L19:
        ((ImageView) r101.findViewById(R.id.flow_relationship_banner_icon)).setImageDrawable(r105.f422766a);
        ((TextView) r101.findViewById(R.id.flow_relationship_banner_title)).setText(r105.f422767b);
        ((TextView) r101.findViewById(R.id.flow_relationship_banner_description)).setText(r105.f422768c);
        return;
    L10:
        if (r104 != 2) goto L17;
        Drawable r106 = UIUtils.getDrawable(r102, R.drawable.flow_ud_ic_block_icon);
        String r107 = UIUtils.getString(r102, R.string.LarkIM_Dm_BlockedUser_Title);
        if (((itb.a) LarkContext.spiByDwarf(itb.a.class)).i1() == false) goto L14;
        String r108 = UIUtils.getString(r102, R.string.LarkIM_Dm_BlockMessagePrompt_Desc);
    L15:
        Intrinsics.checkNotNull(r108);
        r105 = new c(r106, r107, r108);
        goto L19
    L14:
        r108 = UIUtils.getString(r102, R.string.LarkIM_Dm_ChatBlockMessage_Desc);
        goto L15
    L17:
        throw new NoWhenBranchMatchedException();
    }

    @Override // wya.a, wya.b
    public final void c(View r100, wya.c r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f561892f = r100;
        r100.findViewById(R.id.flow_relationship_banner_close).setOnClickListener(new j(this));
        f((d) r101);
    }
}
