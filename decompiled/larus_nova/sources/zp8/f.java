package zp8;

import com.larus.bmhome.instruction.core.impl.controller.DropdownSelectorController;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements com.larus.bmhome.instruction.core.impl.base.g {
    @Override // com.larus.bmhome.instruction.core.impl.base.g
    public final String f() {
        return "DropdownSelectorSubCreator";
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.g
    public final int getMultiItemType() {
        return 3;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.g
    public final com.larus.bmhome.instruction.core.impl.base.e d() {
        return new DropdownSelectorController();
    }

    public f() {
    }
}
