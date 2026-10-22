package com.ss.android.lark.framework.assembly.setting_handler;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.util.share_preference.UserSP;

/* JADX INFO: loaded from: classes36.dex */
@ClaymoreImpl(kpb.a.class)
public class ILarkSettingExportDependencyImpl implements kpb.a {
    private static final String LARKSETTING_EXPORT_SP_NAME = "larksetting_export";
    private static final String LARKSETTING_SP_DOMAIN = "core";
    private static final String TAG = "ILarkSettingExportDependencyImpl";

    public class a implements kpb.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ILarkSettingExportDependencyImpl f425725a;

        public a(ILarkSettingExportDependencyImpl r100) {
            this.f425725a = r100;
        }

        @Override // kpb.a.b
        public final void remove(String r100) {
            ILarkSettingExportDependencyImpl.access$000(this.f425725a).remove(r100);
        }

        @Override // kpb.a.b
        public final String getString(String r100, String r101) {
            return ILarkSettingExportDependencyImpl.access$000(this.f425725a).getString(r100, r101);
        }

        @Override // kpb.a.b
        public final void putString(String r100, String r101) {
            ILarkSettingExportDependencyImpl.access$000(this.f425725a).putString(r100, r101);
        }
    }

    public class b implements kpb.a.InterfaceC6597a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ILarkSettingExportDependencyImpl f425726a;

        public b(ILarkSettingExportDependencyImpl r100) {
            this.f425726a = r100;
        }

        @Override // kpb.a.b
        public final void remove(String r100) {
            ILarkSettingExportDependencyImpl.access$100(this.f425726a).remove(r100);
        }

        @Override // kpb.a.b
        public final String getString(String r100, String r101) {
            return ILarkSettingExportDependencyImpl.access$100(this.f425726a).getString(r100, r101);
        }

        @Override // kpb.a.b
        public final void putString(String r100, String r101) {
            ILarkSettingExportDependencyImpl.access$100(this.f425726a).putString(r100, r101);
        }
    }

    public ILarkSettingExportDependencyImpl() {
    }

    private KVRepo getLarkSettingExportLarkRepo() {
        return LarkKVStorage.f(new com.ss.android.lark.storage.a("core"), LARKSETTING_EXPORT_SP_NAME, new n6c.a(eac.a.a()));
    }

    private KVRepo getLarkSettingExportUserRepo() {
        return LarkKVStorage.o(new com.ss.android.lark.storage.a("core"), LARKSETTING_EXPORT_SP_NAME, new n6c.a(UserSP.getInstance()));
    }

    @Override // kpb.a
    public kpb.a.InterfaceC6597a getLarkRepo() {
        return new b(this);
    }

    @Override // kpb.a
    public kpb.a.c getUserRepo() {
        return new a(this);
    }

    public static /* synthetic */ KVRepo access$000(ILarkSettingExportDependencyImpl r100) {
        return r100.getLarkSettingExportUserRepo();
    }

    public static /* synthetic */ KVRepo access$100(ILarkSettingExportDependencyImpl r100) {
        return r100.getLarkSettingExportLarkRepo();
    }
}
