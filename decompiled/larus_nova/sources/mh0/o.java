package mh0;

import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f513840a;

    public o(p r100) {
        this.f513840a = r100;
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
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        JsonArray r101 = new JsonArray();
        Iterator<T> r102 = ((List) r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        LinkmicPositionItem r103 = (LinkmicPositionItem) r102.next();
        JsonObject r104 = new JsonObject();
        r104.addProperty("position", Long.valueOf(r103.getPosition()));
        r104.addProperty("status", Integer.valueOf(r103.getStatus()));
        r104.addProperty("active_name", r103.getActiveName());
        r104.addProperty("verify_status", Integer.valueOf(r103.getVerifyStatus()));
        r104.addProperty("position_type", Integer.valueOf(r103.getPositionType()));
        r104.addProperty("client_ui_position", Long.valueOf(r103.getClientUIPosition()));
        r101.add(r104);
        goto L4
    L6:
        JsonObject r105 = new JsonObject();
        r105.add("position_items", r101);
        this.f513840a.f513861y.Dk("seat", "position_item_list", r105, false);
    }
}
