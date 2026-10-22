package com.ss.android.lark.mention.base;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.LabelAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.SearchBean;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class MentionUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f431660a = 0;

    static {
    }

    @JvmStatic
    public static final LabelAtBean b() {
        LabelAtBean r100 = new LabelAtBean(UIHelper.getString(R.string.Lark_Chat_AtChatMemberNoResults));
        r100.setBgColorResId(R.color.bg_body);
        r100.setTextSize(16);
        r100.setVerticalPadding(UIHelper.dp2px(20.0f));
        return r100;
    }

    public static List a(List r110) {
        Intrinsics.checkNotNullParameter(r110, "searchData");
        String r100 = UIHelper.getString(R.string.Lark_Chat_AtChatMember);
        String r101 = UIHelper.getString(R.string.Lark_Chat_AtChatMemberNoResults);
        List r102 = CollectionsKt.toMutableList(r110);
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L3:
        boolean r105 = true;
        if (r104.hasNext() == false) goto L8;
        Object r106 = r104.next();
        if ((true ^ Intrinsics.areEqual("mention_ai_knowledge", ((BaseAtBean) r106).getId())) == false) goto L3;
        r103.add(r106);
        goto L3
    L8:
        Log.i("MentionUtils", "aiKnowledgeToTop - searchData size: " + r110.size() + ", filteredData size: " + r103.size());
        ArrayList r111 = new ArrayList();
        int r107 = r103.size();
        int r108 = 0;
    L9:
        if (r108 >= r107) goto L22;
        r111.add(ListProtector.get(r103, r108));
        if (r108 >= (r103.size() - 1)) goto L21;
        BaseAtBean r109 = (BaseAtBean) ListProtector.get(r103, r108);
        BaseAtBean r112 = (BaseAtBean) ListProtector.get(r103, r108 + 1);
        if ((r109 instanceof LabelAtBean) == false) goto L21;
        if (Intrinsics.areEqual(((LabelAtBean) r109).getDisplayName(), r100) == false) goto L21;
        if ((r112 instanceof LabelAtBean) == false) goto L21;
        if (Intrinsics.areEqual(((LabelAtBean) r112).getDisplayName(), r101) == true) goto L21;
        r111.add(b());
    L21:
        r108 = r108 + 1;
        goto L9
    L22:
        Log.i("MentionUtils", "aiKnowledgeToTop - resultData size: " + r111.size());
        if (r111.isEmpty() == true) goto L31;
        Iterator r113 = r111.iterator();
    L27:
        if (r113.hasNext() == false) goto L31;
        if ((((BaseAtBean) r113.next()) instanceof SearchBean) == false) goto L27;
    L32:
        if (r105 == true) goto L34;
        return r111;
    L34:
        ListProtector.add(r111, 0, new SearchBean(new com.ss.android.lark.mention.base.impl.atselector.bean.a(arb.a.f16068b.a0(UIHelper.getString(R.string.Lark_IM_Common_KnowledgeAI_Text)), UIHelper.getString(R.string.Lark_IM_MentionKnoAi_Desc), Chatter.ChatterType.USER)));
        return r111;
    L31:
        r105 = false;
        goto L32
    }

    public static boolean d(Chat r100) {
        if (r100 != null) goto L5;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == true) goto L16;
        if (r100 != null) goto L15;
        return false;
    L15:
        if (r100.isAdmin() == true) goto L16;
        return false;
    L16:
        return true;
    L5:
        if (r100.isP2PChat() == true) goto L11;
        if (r100.getOwnerId() == null) goto L11;
        if (TextUtils.equals(r100.getOwnerId(), b.a().d()) == false) goto L11;
        r101 = true;
        goto L12
    }

    public static List c(List r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "chatterList");
        ArrayList r102 = new ArrayList();
        Iterator r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L13;
        Object r104 = r103.next();
        ChatChatter r105 = (ChatChatter) r104;
        if (r105.isDimission() == false) goto L8;
    L10:
        boolean r106 = false;
    L11:
        if (r106 == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        if (Intrinsics.areEqual(r105.getChatter().getId(), r101) == true) goto L10;
        r106 = true;
        goto L11
    L13:
        return r102;
    }

    public static List e(List r100, List r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "oldData");
        Intrinsics.checkNotNullParameter(r101, "newData");
        List r103 = r101;
        final ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r104.add(((BaseAtBean) r105.next()).getId());
        goto L4
    L6:
        StringBuilder r106 = new StringBuilder("keepOld: ");
        r106.append(r102);
        r106.append(", old: ");
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r108 = r100.iterator();
    L8:
        if (r108.hasNext() == false) goto L10;
        r107.add(((BaseAtBean) r108.next()).getId());
        goto L8
    L10:
        r106.append(r107);
        r106.append(" , new: ");
        r106.append(r104);
        Log.i("MentionUtils", r106.toString());
        List r109 = CollectionsKt.toMutableList(r100);
        if (r102 == true) goto L13;
        CollectionsKt.retainAll(r109, new MentionUtils$mergeMentionLists$2(r104));
    L13:
        List r110 = r109;
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r112 = r110.iterator();
    L15:
        if (r112.hasNext() == false) goto L17;
        r111.add(((BaseAtBean) r112.next()).getId());
        goto L15
    L17:
        ArrayList r113 = new ArrayList();
        Iterator r114 = r103.iterator();
    L19:
        if (r114.hasNext() == false) goto L23;
        Object r115 = r114.next();
        if ((!r111.contains(((BaseAtBean) r115).getId())) == false) goto L19;
        r113.add(r115);
        goto L19
    L23:
        CollectionsKt.addAll(r109, r113);
        StringBuilder r116 = new StringBuilder("mergedList: ");
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r118 = r110.iterator();
    L25:
        if (r118.hasNext() == false) goto L27;
        r117.add(((BaseAtBean) r118.next()).getId());
        goto L25
    L27:
        r116.append(r117);
        Log.i("MentionUtils", r116.toString());
        return r109;
    }

    public static void f(List r100, List r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, "old");
        Intrinsics.checkNotNullParameter(r101, "separatedInChat");
        Intrinsics.checkNotNullParameter(r102, "separatedOutChat");
        ArrayList r103 = new ArrayList();
        Iterator r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();
        if ((r105 instanceof SearchBean) == false) goto L4;
        r103.add(r105);
        goto L4
    L8:
        StringBuilder r106 = new StringBuilder("original data before separated: ");
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r108 = r103.iterator();
    L10:
        if (r108.hasNext() == false) goto L12;
        r107.add(((SearchBean) r108.next()).getId());
        goto L10
    L12:
        r106.append(r107);
        Log.i("MentionUtils", r106.toString());
        Iterator r109 = r103.iterator();
    L14:
        if (r109.hasNext() == false) goto L19;
        SearchBean r110 = (SearchBean) r109.next();
        if (r110.isOutChatUser() == true) goto L17;
        ((ArrayList) r101).add(r110);
        goto L14
    L17:
        ((ArrayList) r102).add(r110);
        goto L14
    }
}
