package com.ss.android.lark.picker.config;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.picker.base.widget.utils.FG;
import com.ss.android.lark.search.dto.UserGroupScene;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes37.dex */
@PickerMaker
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u0010\u001c\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u0010 \u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J1\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u0010&\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u0010(\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u0010*\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u0010,\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u0010.\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u00100\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J)\u00102\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J\u001f\u0010\f\u001a\u00020\u00132\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019J(\u00104\u001a\u0004\u0018\u0001H5\"\u0016\b\u0000\u00105\u0018\u0001*\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\tH\u0086\b¢\u0006\u0002\u00106R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\u0006\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u00067"}, d2 = {"Lcom/ss/android/lark/picker/config/SearcherConfig;", "", ComplianceResult.JsonKey.PERMISSIONS, "Lcom/ss/android/lark/picker/config/Permissions;", "<init>", "(Lcom/ss/android/lark/picker/config/Permissions;)V", "entities", "", "Lkotlin/reflect/KClass;", "Lcom/ss/android/lark/picker/config/Entity;", "getEntities", "()Ljava/util/Map;", "extra", "Lcom/ss/android/lark/picker/config/TopExtra;", "getExtra", "()Lcom/ss/android/lark/picker/config/TopExtra;", "setExtra", "(Lcom/ss/android/lark/picker/config/TopExtra;)V", "chatter", "", "isFull", "", "init", "Lkotlin/Function1;", "Lcom/ss/android/lark/picker/config/Chatter;", "Lkotlin/ExtensionFunctionType;", "group", "Lcom/ss/android/lark/picker/config/Group;", "doc", "Lcom/ss/android/lark/picker/config/Doc;", "wiki", "Lcom/ss/android/lark/picker/config/Wiki;", "wikiSpace", "Lcom/ss/android/lark/picker/config/WikiSpace;", "userGroup", "scene", "Lcom/ss/android/lark/search/dto/UserGroupScene;", "Lcom/ss/android/lark/picker/config/UserGroup;", "shieldP2P", "Lcom/ss/android/lark/picker/config/ShieldP2P;", "department", "Lcom/ss/android/lark/picker/config/Department;", "bot", "Lcom/ss/android/lark/picker/config/Bot;", "mailContact", "Lcom/ss/android/lark/picker/config/MailContact;", "mailUser", "Lcom/ss/android/lark/picker/config/MailUser;", "ai", "Lcom/ss/android/lark/picker/config/AI;", "thread", "Lcom/ss/android/lark/picker/config/Thread;", "getEntity", ExifInterface.LONGITUDE_EAST, "()Lcom/ss/android/lark/picker/config/Entity;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SearcherConfig {
    private final Map<KClass<?>, Entity<?, ?, ?>> entities;
    private TopExtra extra;
    private final Permissions permissions;

    public final /* synthetic */ <E extends Entity<?, ?, ?>> E getEntity() {
        Map<KClass<?>, Entity<?, ?, ?>> r100 = getEntities();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.LONGITUDE_EAST);
        E r101 = (E) r100.get(Reflection.getOrCreateKotlinClass(Entity.class));
        if (r101 == null) goto L5;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        Intrinsics.reifiedOperationMarker(1, ExifInterface.LONGITUDE_EAST);
        return r101;
    L5:
        return null;
    }

    public final Map<KClass<?>, Entity<?, ?, ?>> getEntities() {
        return this.entities;
    }

    public final TopExtra getExtra() {
        return this.extra;
    }

    public SearcherConfig(Permissions r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
        this.permissions = r100;
        this.entities = new LinkedHashMap();
        this.extra = new TopExtra();
    }

    public final void extra(Function1<? super TopExtra, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "init");
        r100.invoke(this.extra);
    }

    public final void setExtra(TopExtra r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extra = r100;
    }

    public final void ai(boolean r100, Function1<? super AI, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "init");
        if (FG.INSTANCE.isCurrentEnable(FG.MY_AI) == true) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        AI r102 = new AI();
    L13:
        r101.invoke(r102);
        this.entities.put(Reflection.getOrCreateKotlinClass(AI.class), r102);
        return;
    L7:
        Entity<?, ?, ?> r103 = this.entities.get(Reflection.getOrCreateKotlinClass(AI.class));
        if ((r103 instanceof AI) == false) goto L10;
        r102 = (AI) r103;
    L11:
        if (r102 != null) goto L13;
        r102 = new AI();
        goto L13
    L10:
        r102 = null;
        goto L11
    }

    public final void bot(boolean r100, Function1<? super Bot, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "init");
        if (r100 == false) goto L5;
        Bot r102 = new Bot();
    L11:
        r101.invoke(r102);
        this.entities.put(Reflection.getOrCreateKotlinClass(Bot.class), r102);
        return;
    L5:
        Entity<?, ?, ?> r103 = this.entities.get(Reflection.getOrCreateKotlinClass(Bot.class));
        if ((r103 instanceof Bot) == false) goto L8;
        r102 = (Bot) r103;
    L9:
        if (r102 != null) goto L11;
        r102 = new Bot();
        goto L11
    L8:
        r102 = null;
        goto L9
    }

    public final void chatter(boolean r100, Function1<? super Chatter, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "init");
        if (r100 == false) goto L5;
        Chatter r102 = new Chatter();
    L11:
        r101.invoke(r102);
        r102.getExtra().setReturnPermissionsResult$picker_release(this.permissions.getChatterOUPermissions());
        this.entities.put(Reflection.getOrCreateKotlinClass(Chatter.class), r102);
        return;
    L5:
        Entity<?, ?, ?> r103 = this.entities.get(Reflection.getOrCreateKotlinClass(Chatter.class));
        if ((r103 instanceof Chatter) == false) goto L8;
        r102 = (Chatter) r103;
    L9:
        if (r102 != null) goto L11;
        r102 = new Chatter();
        goto L11
    L8:
        r102 = null;
        goto L9
    }

    public final void department(boolean r100, Function1<? super Department, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "init");
        if (r100 == false) goto L5;
        Department r102 = new Department();
    L11:
        r101.invoke(r102);
        this.entities.put(Reflection.getOrCreateKotlinClass(Department.class), r102);
        return;
    L5:
        Entity<?, ?, ?> r103 = this.entities.get(Reflection.getOrCreateKotlinClass(Department.class));
        if ((r103 instanceof Department) == false) goto L8;
        r102 = (Department) r103;
    L9:
        if (r102 != null) goto L11;
        r102 = new Department();
        goto L11
    L8:
        r102 = null;
        goto L9
    }

    public final void doc(boolean r100, Function1<? super Doc, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "init");
        if (r100 == false) goto L5;
        Doc r102 = new Doc();
    L11:
        r101.invoke(r102);
        this.entities.put(Reflection.getOrCreateKotlinClass(Doc.class), r102);
        return;
    L5:
        Entity<?, ?, ?> r103 = this.entities.get(Reflection.getOrCreateKotlinClass(Doc.class));
        if ((r103 instanceof Doc) == false) goto L8;
        r102 = (Doc) r103;
    L9:
        if (r102 != null) goto L11;
        r102 = new Doc();
        goto L11
    L8:
        r102 = null;
        goto L9
    }

    public final void group(boolean r100, Function1<? super Group, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "init");
        if (r100 == false) goto L5;
        Group r102 = new Group();
    L11:
        r101.invoke(r102);
        this.entities.put(Reflection.getOrCreateKotlinClass(Group.class), r102);
        return;
    L5:
        Entity<?, ?, ?> r103 = this.entities.get(Reflection.getOrCreateKotlinClass(Group.class));
        if ((r103 instanceof Group) == false) goto L8;
        r102 = (Group) r103;
    L9:
        if (r102 != null) goto L11;
        r102 = new Group();
        goto L11
    L8:
        r102 = null;
        goto L9
    }

    public final void mailContact(boolean r100, Function1<? super MailContact, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "init");
        if (r100 == false) goto L5;
        MailContact r102 = new MailContact();
    L11:
        r101.invoke(r102);
        this.entities.put(Reflection.getOrCreateKotlinClass(MailContact.class), r102);
        return;
    L5:
        Entity<?, ?, ?> r103 = this.entities.get(Reflection.getOrCreateKotlinClass(MailContact.class));
        if ((r103 instanceof MailContact) == false) goto L8;
        r102 = (MailContact) r103;
    L9:
        if (r102 != null) goto L11;
        r102 = new MailContact();
        goto L11
    L8:
        r102 = null;
        goto L9
    }

    public final void mailUser(boolean r100, Function1<? super MailUser, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "init");
        if (r100 == false) goto L5;
        MailUser r102 = new MailUser();
    L11:
        r101.invoke(r102);
        this.entities.put(Reflection.getOrCreateKotlinClass(MailUser.class), r102);
        return;
    L5:
        Entity<?, ?, ?> r103 = this.entities.get(Reflection.getOrCreateKotlinClass(MailUser.class));
        if ((r103 instanceof MailUser) == false) goto L8;
        r102 = (MailUser) r103;
    L9:
        if (r102 != null) goto L11;
        r102 = new MailUser();
        goto L11
    L8:
        r102 = null;
        goto L9
    }

    public final void shieldP2P(boolean r100, Function1<? super ShieldP2P, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "init");
        if (r100 == false) goto L5;
        ShieldP2P r102 = new ShieldP2P();
    L11:
        r101.invoke(r102);
        this.entities.put(Reflection.getOrCreateKotlinClass(ShieldP2P.class), r102);
        return;
    L5:
        Entity<?, ?, ?> r103 = this.entities.get(Reflection.getOrCreateKotlinClass(ShieldP2P.class));
        if ((r103 instanceof ShieldP2P) == false) goto L8;
        r102 = (ShieldP2P) r103;
    L9:
        if (r102 != null) goto L11;
        r102 = new ShieldP2P();
        goto L11
    L8:
        r102 = null;
        goto L9
    }

    public final void thread(boolean r100, Function1<? super Thread, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "init");
        if (r100 == false) goto L5;
        Thread r102 = new Thread();
    L11:
        r101.invoke(r102);
        this.entities.put(Reflection.getOrCreateKotlinClass(Thread.class), r102);
        return;
    L5:
        Entity<?, ?, ?> r103 = this.entities.get(Reflection.getOrCreateKotlinClass(Thread.class));
        if ((r103 instanceof Thread) == false) goto L8;
        r102 = (Thread) r103;
    L9:
        if (r102 != null) goto L11;
        r102 = new Thread();
        goto L11
    L8:
        r102 = null;
        goto L9
    }

    public final void wiki(boolean r100, Function1<? super Wiki, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "init");
        if (r100 == false) goto L5;
        Wiki r102 = new Wiki();
    L11:
        r101.invoke(r102);
        this.entities.put(Reflection.getOrCreateKotlinClass(Wiki.class), r102);
        return;
    L5:
        Entity<?, ?, ?> r103 = this.entities.get(Reflection.getOrCreateKotlinClass(Wiki.class));
        if ((r103 instanceof Wiki) == false) goto L8;
        r102 = (Wiki) r103;
    L9:
        if (r102 != null) goto L11;
        r102 = new Wiki();
        goto L11
    L8:
        r102 = null;
        goto L9
    }

    public final void wikiSpace(boolean r100, Function1<? super WikiSpace, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "init");
        if (r100 == false) goto L5;
        WikiSpace r102 = new WikiSpace();
    L11:
        r101.invoke(r102);
        this.entities.put(Reflection.getOrCreateKotlinClass(WikiSpace.class), r102);
        return;
    L5:
        Entity<?, ?, ?> r103 = this.entities.get(Reflection.getOrCreateKotlinClass(WikiSpace.class));
        if ((r103 instanceof WikiSpace) == false) goto L8;
        r102 = (WikiSpace) r103;
    L9:
        if (r102 != null) goto L11;
        r102 = new WikiSpace();
        goto L11
    L8:
        r102 = null;
        goto L9
    }

    public final void userGroup(UserGroupScene r100, boolean r101, Function1<? super UserGroup, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r102, "init");
        if (r101 == false) goto L5;
        UserGroup r103 = new UserGroup(r100);
    L11:
        r102.invoke(r103);
        this.entities.put(Reflection.getOrCreateKotlinClass(UserGroup.class), r103);
        return;
    L5:
        Entity<?, ?, ?> r104 = this.entities.get(Reflection.getOrCreateKotlinClass(UserGroup.class));
        if ((r104 instanceof UserGroup) == false) goto L8;
        r103 = (UserGroup) r104;
    L9:
        if (r103 != null) goto L11;
        r103 = new UserGroup(r100);
        goto L11
    L8:
        r103 = null;
        goto L9
    }

    public static /* synthetic */ void ai$default(SearcherConfig r100, boolean r101, Function1 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        r100.ai(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ai");
    }

    public static /* synthetic */ void bot$default(SearcherConfig r100, boolean r101, Function1 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        r100.bot(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bot");
    }

    public static /* synthetic */ void chatter$default(SearcherConfig r100, boolean r101, Function1 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        r100.chatter(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: chatter");
    }

    public static /* synthetic */ void department$default(SearcherConfig r100, boolean r101, Function1 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        r100.department(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: department");
    }

    public static /* synthetic */ void doc$default(SearcherConfig r100, boolean r101, Function1 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        r100.doc(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doc");
    }

    public static /* synthetic */ void group$default(SearcherConfig r100, boolean r101, Function1 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        r100.group(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: group");
    }

    public static /* synthetic */ void mailContact$default(SearcherConfig r100, boolean r101, Function1 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        r100.mailContact(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: mailContact");
    }

    public static /* synthetic */ void mailUser$default(SearcherConfig r100, boolean r101, Function1 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        r100.mailUser(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: mailUser");
    }

    public static /* synthetic */ void shieldP2P$default(SearcherConfig r100, boolean r101, Function1 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        r100.shieldP2P(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: shieldP2P");
    }

    public static /* synthetic */ void thread$default(SearcherConfig r100, boolean r101, Function1 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        r100.thread(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: thread");
    }

    public static /* synthetic */ void wiki$default(SearcherConfig r100, boolean r101, Function1 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        r100.wiki(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: wiki");
    }

    public static /* synthetic */ void wikiSpace$default(SearcherConfig r100, boolean r101, Function1 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        r100.wikiSpace(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: wikiSpace");
    }

    public static /* synthetic */ void userGroup$default(SearcherConfig r100, UserGroupScene r101, boolean r102, Function1 r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        r100.userGroup(r101, r102, r103);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userGroup");
    }
}
