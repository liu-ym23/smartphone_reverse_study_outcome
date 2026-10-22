package com.bytedance.ee.bear.sheet.cellcontent;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaInputStyleData;
import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

        public void setColoredRanges(List<FormulaInputStyleData.ColoredRange> r1) {
            this.coloredRanges = r1;
        }

        public void setFormula(String r1) {
            this.formula = r1;
        }

        public void setFormulaTitle(String r1) {
            this.formulaTitle = r1;
        }

        public void setResult(String r1) {
            this.result = r1;
        }

        public void setResultTitle(String r1) {
            this.resultTitle = r1;
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

    public void setBgColor(String r1) {
        this.bgColor = r1;
    }

    public void setCopyable(boolean r1) {
        this.copyable = r1;
    }

    public void setData(SheetInputData.InputData r1) {
        this.data = r1;
    }

    public void setFormulaData(FormulaData r1) {
        this.formulaData = r1;
    }

    public void setHideFAB(boolean r1) {
        this.hideFAB = r1;
    }

    public void setMinHeight(float r1) {
        this.minHeight = r1;
    }
}
