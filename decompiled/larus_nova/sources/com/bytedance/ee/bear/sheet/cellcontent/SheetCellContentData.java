package com.bytedance.ee.bear.sheet.cellcontent;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaInputStyleData;
import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class SheetCellContentData implements NonProguard {
    private String bgColor;
    private boolean copyable;
    private SheetInputData.InputData data;
    private FormulaData formulaData;
    private boolean hideFAB;
    private float minHeight;

    public static class FormulaData implements NonProguard {

        @JSONField(alternateNames = {"colored_ranges"}, name = "coloredRanges")
        private List<FormulaInputStyleData.ColoredRange> coloredRanges;
        private String formula;

        @JSONField(alternateNames = {"formula_title"}, name = "formulaTitle")
        private String formulaTitle;
        private String result;

        @JSONField(alternateNames = {"result_title"}, name = "resultTitle")
        private String resultTitle;

        public FormulaData() {
        }

        public List<FormulaInputStyleData.ColoredRange> getColoredRanges() {
            return this.coloredRanges;
        }

        public String getFormula() {
            return this.formula;
        }

        public String getFormulaTitle() {
            return this.formulaTitle;
        }

        public String getResult() {
            return this.result;
        }

        public String getResultTitle() {
            return this.resultTitle;
        }

        public void setColoredRanges(List<FormulaInputStyleData.ColoredRange> r100) {
            this.coloredRanges = r100;
        }

        public void setFormula(String r100) {
            this.formula = r100;
        }

        public void setFormulaTitle(String r100) {
            this.formulaTitle = r100;
        }

        public void setResult(String r100) {
            this.result = r100;
        }

        public void setResultTitle(String r100) {
            this.resultTitle = r100;
        }
    }

    public SheetCellContentData() {
    }

    public String getBgColor() {
        return this.bgColor;
    }

    public SheetInputData.InputData getData() {
        return this.data;
    }

    public FormulaData getFormulaData() {
        return this.formulaData;
    }

    public float getMinHeight() {
        return this.minHeight;
    }

    public boolean isCopyable() {
        return this.copyable;
    }

    public boolean isHideFAB() {
        return this.hideFAB;
    }

    public void setBgColor(String r100) {
        this.bgColor = r100;
    }

    public void setCopyable(boolean r100) {
        this.copyable = r100;
    }

    public void setData(SheetInputData.InputData r100) {
        this.data = r100;
    }

    public void setFormulaData(FormulaData r100) {
        this.formulaData = r100;
    }

    public void setHideFAB(boolean r100) {
        this.hideFAB = r100;
    }

    public void setMinHeight(float r100) {
        this.minHeight = r100;
    }
}
